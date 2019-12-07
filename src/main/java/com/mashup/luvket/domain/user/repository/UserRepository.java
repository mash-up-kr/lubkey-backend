package com.mashup.luvket.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.luvket.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
