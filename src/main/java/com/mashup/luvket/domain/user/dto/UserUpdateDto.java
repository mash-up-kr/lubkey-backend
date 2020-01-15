package com.mashup.luvket.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserUpdateDto {

    private String name;
    private String profileImageUrl;     // TODO MultipartFile 로 변경

    @Builder
    public UserUpdateDto(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
}
