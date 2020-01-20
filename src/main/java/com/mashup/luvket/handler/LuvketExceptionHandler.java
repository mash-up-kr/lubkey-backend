package com.mashup.luvket.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mashup.luvket.domain.exception.CannotInviteException;
import com.mashup.luvket.domain.exception.ExpiredInviteTokenException;
import com.mashup.luvket.domain.exception.InvalidInviteTokenException;
import com.mashup.luvket.domain.exception.NotFoundEntityException;
import com.mashup.luvket.model.ErrorInfo;

@RestControllerAdvice
public class LuvketExceptionHandler {

	@ExceptionHandler(NotFoundEntityException.class)
	public ResponseEntity<ErrorInfo> notFoundEntityExceptionHandler(NotFoundEntityException exception) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ErrorInfo(exception.getErrorCode(), exception.getErrorMsg()));
	}

	@ExceptionHandler(ExpiredInviteTokenException.class)
	public ResponseEntity<ErrorInfo> expiredInviteTokenException(ExpiredInviteTokenException exception) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new ErrorInfo(exception.getErrorCode(), exception.getErrorMsg()));
	}

	@ExceptionHandler(InvalidInviteTokenException.class)
	public ResponseEntity<ErrorInfo> invalidInviteTokenException(InvalidInviteTokenException exception) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorInfo(exception.getErrorCode(), exception.getErrorMsg()));
	}
	
	@ExceptionHandler(CannotInviteException.class)
	public ResponseEntity<ErrorInfo> cannotInviteException(CannotInviteException exception) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorInfo(exception.getErrorCode(), exception.getErrorMsg()));
	}

}
