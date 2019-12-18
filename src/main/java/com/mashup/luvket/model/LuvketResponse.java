package com.mashup.luvket.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LuvketResponse<T> {
	
	private int code;
	private String message;
	private T data;
	
}
