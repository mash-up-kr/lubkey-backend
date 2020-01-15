package com.mashup.luvket.domain.luvket.dto;


import com.mashup.luvket.domain.constant.status.Status;
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
    public LuvketDto(Long userId, String title, Long categoryId, Status status, boolean publicOpen, Long scheduleId){
        this.userId = userId;
        this.title = title;
        this.categoryId = categoryId;
        this.status = status;
        this.publicOpen = publicOpen;
        this.scheduleId = scheduleId;
    }
}
