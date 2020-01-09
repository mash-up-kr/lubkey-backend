package com.mashup.luvket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//	@PostMapping("/invite")
//	public LuvketResponse<TokenDto> createUserHashCode(@RequestHeader(value = "uid") String uid) {
//		return LuvketResponse.<TokenDto>builder()
//					.code(HttpStatus.OK.value())
//					.message("초대 토큰 생성 성공")
//					.data(userService.createToken(uid))
//					.build();
//	}

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
