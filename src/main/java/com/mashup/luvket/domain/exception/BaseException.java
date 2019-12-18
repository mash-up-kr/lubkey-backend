package com.mashup.luvket.domain.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

	private int errorCode;
	private String errorMsg;

	BaseException(int errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

}
