package com.mashup.luvket.domain.luvket.dto;

import com.mashup.luvket.domain.constant.status.Status;
import com.mashup.luvket.domain.luvket.entity.Luvket;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LuvketDto {

	private Long userId;
	private String title;
	private Long categoryId;
	private Status status;
	private boolean publicOpen;
	private Long scheduleId;

	@Builder
	public LuvketDto(Long userId, String title, Long categoryId, Status status, boolean publicOpen, Long scheduleId) {
		this.userId = userId;
		this.title = title;
		this.categoryId = categoryId;
		this.status = status;
		this.publicOpen = publicOpen;
		this.scheduleId = scheduleId;
	}

    public static LuvketDto of(Luvket luvket) {
    	return LuvketDto.builder()
    			.userId(luvket.getUserId())
    			.title(luvket.getTitle())
    			.categoryId(luvket.getCategoryId())
    			.status(luvket.getStatus())
    			.publicOpen(luvket.isPublicOpen())
    			.scheduleId(luvket.getScheduleId())
    			.build();
    }
}
