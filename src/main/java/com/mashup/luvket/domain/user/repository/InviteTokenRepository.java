package com.mashup.luvket.domain.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.luvket.domain.user.entity.InviteToken;

public interface InviteTokenRepository extends JpaRepository<InviteToken, Long> {

	Optional<InviteToken> findByUserId(Long userId);

	void deleteByUserId(Long userId);

}
