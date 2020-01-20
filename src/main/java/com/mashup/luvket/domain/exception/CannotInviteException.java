package com.mashup.luvket.domain.exception;

public class CannotInviteException extends BaseException {

	public CannotInviteException(String errorMsg) {
		super(4403, errorMsg);
	}

	public CannotInviteException() {
		this("올바르지 않은 초대입니다.");
	}

}
