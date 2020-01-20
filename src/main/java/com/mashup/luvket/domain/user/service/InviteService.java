package com.mashup.luvket.domain.user.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mashup.luvket.domain.exception.CannotInviteException;
import com.mashup.luvket.domain.exception.InvalidInviteTokenException;
import com.mashup.luvket.domain.user.dto.TokenDto;
import com.mashup.luvket.domain.user.dto.UserDto;
import com.mashup.luvket.domain.user.entity.InviteToken;
import com.mashup.luvket.domain.user.entity.User;
import com.mashup.luvket.domain.user.repository.InviteTokenRepository;
import com.mashup.luvket.util.TokenUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InviteService {
	
	private final InviteTokenRepository inviteTokenRepository;
	private final UserService userService;
	private final UserToUserService userToUserService;

	@Transactional
	public TokenDto createInviteToken(String uid) {
		User user = userService.getUser(uid);

		inviteTokenRepository.findByUserId(user.getId()).ifPresent(inviteToken -> {
			inviteTokenRepository.deleteByUserId(user.getId());
		});
		
		String token = TokenUtils.generateInviteToken();
		
		InviteToken inviteToken = InviteToken.create(user, token);
		inviteTokenRepository.save(inviteToken);
		
		return new TokenDto(token);
	}
	
	public UserDto getInvitingUser(String token) {
		validateTokenLength(token);
		
		InviteToken inviteToken = getInviteToken(token);
		
		inviteToken.validateExpired();

		User user = inviteToken.getUser();
		return new UserDto(user.getName(), user.getProfileImageUrl());
	}

	private void validateTokenLength(String token) {
		if (InviteToken.INVITE_TOKEN_LENGTH != token.length())
			throw new InvalidInviteTokenException();
	}

	public void acceptInvite(String uid, String token) {
		User inviteUser = getInviteToken(token).getUser();
		User user = userService.getUser(uid);

		if (inviteUser.equals(user))
			throw new CannotInviteException();

		if(!inviteUser.isAlone() || !user.isAlone())
			throw new CannotInviteException();

		inviteUser.inviting();
		user.accepted();

		userToUserService.create(inviteUser, user);
	}

	private InviteToken getInviteToken(String token) {
		return inviteTokenRepository
				.findByToken(token)
				.orElseThrow(InvalidInviteTokenException::new);
	}

}
