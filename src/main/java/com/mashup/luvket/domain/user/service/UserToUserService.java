package com.mashup.luvket.domain.user.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mashup.luvket.domain.exception.NotFoundEntityException;
import com.mashup.luvket.domain.user.entity.User;
import com.mashup.luvket.domain.user.entity.UserToUser;
import com.mashup.luvket.domain.user.repository.UserToUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserToUserService {

	private final UserToUserRepository userToUserRepository;

	public UserToUser create(User fromUser, User toUser) {
		UserToUser userToUser = UserToUser.create(fromUser, toUser);

		userToUserRepository.save(userToUser);

		return userToUser;
	}

	public UserToUser getFromUser(Long id) {
		return userToUserRepository.findByFromUserId(id).orElseThrow(NotFoundEntityException::new);
	}

	public Set<Long> getUserIds(Long id) {

		// TODO index 추가 필요
		UserToUser userToUser = userToUserRepository.findByFromUserIdOrToUserId(id, id)
				.orElseThrow(NotFoundEntityException::new);

		return userToUser.getuserIds();
	}

}
