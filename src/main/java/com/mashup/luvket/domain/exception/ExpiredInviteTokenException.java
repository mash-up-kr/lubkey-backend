package com.mashup.luvket.domain.exception;

public class ExpiredInviteTokenException extends BaseException {

	public ExpiredInviteTokenException(String errorMsg) {
		super(4401, errorMsg);
	}

	public ExpiredInviteTokenException() {
		this("시간이 만료된 초대 토큰입니다.");
	}
}
