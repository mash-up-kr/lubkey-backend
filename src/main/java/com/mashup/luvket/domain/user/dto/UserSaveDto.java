package com.mashup.luvket.domain.user.dto;

import com.mashup.luvket.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSaveDto {

    private String uid;
    private String email;
    private String name;
    private String profileImageUrl;
    //authType
    //Status

    @Builder
    public UserSaveDto(String uid, String email, String name, String profileImageUrl){
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public User toEntity(){
        return User.builder()
                .uid(uid)
                .email(email)
                .name(name)
                .profileImageUrl(profileImageUrl)
                .build();
    }

}
