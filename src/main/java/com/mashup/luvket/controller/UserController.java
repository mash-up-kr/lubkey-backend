package com.mashup.luvket.controller;

import com.mashup.luvket.domain.user.dto.UserSaveDto;
import com.mashup.luvket.domain.user.dto.UserSaveResponseDto;
import org.springframework.http.HttpStatus;
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
    @ResponseBody
    public LuvketResponse<UserSaveResponseDto> save(@RequestBody UserSaveDto userSaveDto) {
        return userService.save(userSaveDto);
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
