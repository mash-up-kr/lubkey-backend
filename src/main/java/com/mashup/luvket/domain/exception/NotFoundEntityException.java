package com.mashup.luvket.domain.exception;

public class NotFoundEntityException extends BaseException {
	
	public NotFoundEntityException(String errorMsg) {
        super(4004, errorMsg);
    }

    public NotFoundEntityException() {
        this("해당 데이터가 존재하지 않습니다.");
    }

}
