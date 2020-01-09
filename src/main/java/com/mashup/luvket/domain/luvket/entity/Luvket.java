package com.mashup.luvket.domain.luvket.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.mashup.luvket.domain.constant.status.Status;

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
@Entity
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "luvkets")
public class Luvket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private String title;
	private String memo;
	private String location;
	private Long categoryId;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column(name = "is_public_open")
	private boolean publicOpen;
	private Long scheduleId;

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
	
	public static Luvket create(String title, String memo) {
		return Luvket.builder()
			.title(title)
//			.memo(memo)
			.build();
	}

	@Builder
	public Luvket(Long userId, String title, Long categoryId, Status status, boolean publicOpen, Long scheduleId){
		this.userId = userId;
		this.title = title;
		this.categoryId = categoryId;
		this.status = status;
		this.publicOpen = publicOpen;
		this.scheduleId = scheduleId;
	}
}
