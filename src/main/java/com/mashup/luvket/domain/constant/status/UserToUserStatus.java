package com.mashup.luvket.domain.constant.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserToUserStatus {
	
	WAITING("대기중"),
	CONNECTING("연결");

	private String description;

}
