package com.mashup.luvket.domain.user.service;

import com.mashup.luvket.domain.user.dto.UserSaveDto;
import com.mashup.luvket.domain.user.dto.UserSaveResponseDto;
import com.mashup.luvket.domain.user.entity.User;
import com.mashup.luvket.domain.user.repository.UserRepository;
import com.mashup.luvket.domain.user.dto.UserUpdateDto;
//import com.mashup.luvket.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

//    private final S3Uploader s3Uploader;

    // userId, email, name, profileImageUrl(S3로 넘기지 않음)
    public UserSaveResponseDto save(UserSaveDto userSaveDto){

        User user = userRepository.save(userSaveDto.toEntity());
        UserSaveResponseDto response = new UserSaveResponseDto(user.getId(), user.getName(), user.getProfileImageUrl());

        return response;
    }
    /*
    // 수정했을 때 url return
    public String update(Long id, UserUpdateDto userUpdateDto) throws IOException {
//        MultipartFile multipartFile
//        String url = s3Uploader.upload(multipartFile, "static");

        String url = userUpdateDto.getProfileImageUrl();
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" +id));

        user.update(userUpdateDto.getName(), url);
        userRepository.save(user);

        return url;
    }*/
}
