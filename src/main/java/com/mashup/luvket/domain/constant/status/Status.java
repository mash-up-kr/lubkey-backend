package com.mashup.luvket.domain.constant.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	
	OK("정상"),
	COMPLETE("완료"),
	DELETE("삭제");

	private String description;

}
