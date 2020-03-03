package com.mashup.luvket.domain.luvket;

import java.util.HashSet;
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
	private boolean complete;
	private boolean publicOpen;

	public Status getStatus() {
		return complete ? Status.COMPLETE : Status.OK;
	}

	public String getTitle() {
		return title == null ? "" : title;
	}

	public Set<Long> getCategoryIds() {
		return categoryIds == null ? new HashSet<>() : categoryIds;
	}

}