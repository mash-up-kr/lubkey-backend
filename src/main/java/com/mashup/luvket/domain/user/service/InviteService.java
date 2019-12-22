package com.mashup.luvket.domain.user.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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

	@Transactional
	public TokenDto createInviteToken(String uid) {
		// TODO UserService 추가시 수정 필요
		User user = null;
		
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
		
		InviteToken inviteToken = inviteTokenRepository.findByToken(token).orElseThrow(InvalidInviteTokenException::new);
		
		inviteToken.validateExpired();

		// TODO UserService 추가시 수정 필요
		User user = null;
		
		return new UserDto(user.getName(), user.getProfileImageUrl());
	}

	private void validateTokenLength(String token) {
		if (InviteToken.INVITE_TOKEN_LENGTH != token.length())
			throw new InvalidInviteTokenException();
	}

}
