package com.mashup.luvket.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSaveResponseDto {

    private Long id;
    private String name;
    private String profileImageUrl;

    @Builder
    public UserSaveResponseDto(Long id, String name, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
}
