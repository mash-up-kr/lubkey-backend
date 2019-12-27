package com.mashup.luvket.domain.user.service;

import org.springframework.stereotype.Service;

import com.mashup.luvket.domain.exception.NotFoundEntityException;
import com.mashup.luvket.domain.user.entity.User;
import com.mashup.luvket.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	public User get(Long id) {
		return userRepository.findById(id).orElseThrow(NotFoundEntityException::new);
	}

	public User get(String uid) {
		return userRepository.findByUid(uid).orElseThrow(NotFoundEntityException::new);
	}
}
