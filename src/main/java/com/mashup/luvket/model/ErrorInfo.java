package com.mashup.luvket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorInfo {
	
	private int errorCode;
    private String errorMsg;
}
