package com.mashup.luvket.domain.user.entity;

import java.time.LocalDateTime;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import com.mashup.luvket.domain.constant.status.Status;
import com.mashup.luvket.domain.exception.ExpiredInviteTokenException;

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
@Table(name = "invite_tokens")
public class InviteToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
	private String token;
	@Enumerated(EnumType.STRING)
	private Status status;

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
	
	public static final int INVITE_TOKEN_LENGTH = 10;
	public static final int EXPIRE_DAY = 3;
	
	public static InviteToken create(User user, String token) {
		return InviteToken.builder()
					.user(user)
					.token(token)
					.status(Status.OK)
					.build();
    }

	public void validateExpired() {
		LocalDateTime expiredTime = createdAt.plusDays(EXPIRE_DAY);

		if (expiredTime.isBefore(LocalDateTime.now()))
			throw new ExpiredInviteTokenException();
	}
}
