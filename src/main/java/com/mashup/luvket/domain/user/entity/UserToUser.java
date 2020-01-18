package com.mashup.luvket.domain.user.entity;

import java.time.LocalDateTime;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.mashup.luvket.domain.constant.status.UserToUserStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_to_user")
public class UserToUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "from_user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	@OneToOne(fetch = FetchType.LAZY)
	private User fromUser;
	@JoinColumn(name = "to_user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	@OneToOne(fetch = FetchType.LAZY)
	private User toUser;
	private UserToUserStatus status;

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

	public static UserToUser create(User fromUser, User toUser) {
		return UserToUser.builder()
				.fromUser(fromUser)
				.toUser(toUser)
				.status(UserToUserStatus.CONNECTING)
				.build();
	}

}
