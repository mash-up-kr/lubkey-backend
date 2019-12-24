package com.mashup.luvket.controller;

import com.mashup.luvket.domain.user.dto.UserSaveDto;
import com.mashup.luvket.domain.user.dto.UserSaveResponseDto;
import com.mashup.luvket.domain.user.dto.UserUpdateDto;
import com.mashup.luvket.domain.user.service.UserService;
import com.mashup.luvket.model.LuvketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    @ResponseBody
    public LuvketResponse<UserSaveResponseDto> save(@RequestBody UserSaveDto userSaveDto) {
        return LuvketResponse.<UserSaveResponseDto>builder()
                .code(HttpStatus.OK.value())
                .message("사용자 생성 성공")
                .data(userService.save(userSaveDto))
                .build();
    }

    // TODO MultipartFile 받아 S3 저장하기
    /*@PutMapping("/{id}")
    @ResponseBody
    public String saveUserInfo(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) throws IOException {
        return userService.update(id, userUpdateDto);
    }*/
}
