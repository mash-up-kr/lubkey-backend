package com.mashup.luvket.domain.luvket;

import java.util.Set;

import com.mashup.luvket.domain.constant.status.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LuvketPageRequest {

	private int page;
	private String title;
	private Set<Long> categoryIds;
	private boolean isComplete;
	private boolean isPublic;

	public Status getStatus() {
		return isComplete ? Status.COMPLETE : Status.OK;
	}

}
