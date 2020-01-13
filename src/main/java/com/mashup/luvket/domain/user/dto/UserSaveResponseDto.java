package com.mashup.luvket.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserSaveResponseDto {

    private Long id;
    private String name;
    private String profileImageUrl;
}
