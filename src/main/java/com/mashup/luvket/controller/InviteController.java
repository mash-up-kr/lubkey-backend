package com.mashup.luvket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.luvket.domain.user.dto.TokenDto;
import com.mashup.luvket.domain.user.service.InviteService;
import com.mashup.luvket.model.LuvketResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/invites")
public class InviteController {

	private final InviteService inviteService;

	@PostMapping("/")
	public LuvketResponse<TokenDto> createUserHashCode(@RequestHeader(value = "uid") String uid) {
		return LuvketResponse.<TokenDto>builder()
					.code(HttpStatus.OK.value())
					.message("초대 토큰 생성 성공")
					.data(inviteService.createInviteToken(uid))
					.build();
	}
}
