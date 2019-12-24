package com.mashup.luvket.domain.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.mashup.luvket.domain.constant.AuthType;
import com.mashup.luvket.domain.constant.status.UserStatus;

import lombok.*;

@Getter
@EqualsAndHashCode(of = "uid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uid;
	private String email;
	private String name;
	private String profileImageUrl;
	@Enumerated(EnumType.STRING)
	private AuthType authType;
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@PrePersist
	private void onInit() {
		LocalDateTime now = LocalDateTime.now();
		this.createdAt = now;
		this.updatedAt = now;
	}

	@PreUpdate
	private void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	@Builder
	public User(String uid, String email, String name, String profileImageUrl){
		this.uid = uid;
		this.email = email;
		this.name = name;
		this.profileImageUrl = profileImageUrl;
	}

	public void update(String name, String profileImageUrl){
		this.name = name;
		this.profileImageUrl = profileImageUrl;
	}
}
