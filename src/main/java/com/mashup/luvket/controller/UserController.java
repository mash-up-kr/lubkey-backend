package com.mashup.luvket.controller;

import com.mashup.luvket.domain.user.dto.UserDto;
import com.mashup.luvket.domain.user.dto.UserSaveDto;
import com.mashup.luvket.domain.user.dto.UserSaveResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mashup.luvket.domain.user.dto.TokenDto;
import com.mashup.luvket.domain.user.entity.User;
import com.mashup.luvket.domain.user.service.UserService;
import com.mashup.luvket.model.LuvketResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<LuvketResponse<UserSaveResponseDto>> save(@RequestBody UserSaveDto userSaveDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(LuvketResponse.<UserSaveResponseDto>builder()
                        .code(HttpStatus.OK.value())
                        .message("사용자 생성 완료")
                        .data(userService.save(userSaveDto))
                        .build());
    }

//	@GetMapping("/invite/{inviteToken}")
//	public void getUserHashCode(@PathVariable(value = "hashCode") String hashCode) {
//		User user = userService.getUserByToken(hashCode);
//	}
//	
//	@PostMapping("/acceptance")
//	public void acceptInvite(@RequestHeader(value = "uid") String uid) {
////		userService.acceptInvite(uid, fromUserId);
//	}
}
