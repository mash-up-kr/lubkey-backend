package com.mashup.luvket.domain.exception;

public class InvalidInviteTokenException extends BaseException {

	public InvalidInviteTokenException(String errorMsg) {
        super(4402, errorMsg);
    }

    public InvalidInviteTokenException() {
        this("올바르지 않은 초대 토큰 입니다.");
    }
	
}