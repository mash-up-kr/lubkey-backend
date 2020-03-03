package com.mashup.luvket.domain.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.luvket.domain.user.entity.UserToUser;

public interface UserToUserRepository extends JpaRepository<UserToUser, Long> {

	Optional<UserToUser> findByFromUserId(Long id);

	Optional<UserToUser> findByFromUserIdOrToUserId(Long fromUserId, Long toUserId);

}
