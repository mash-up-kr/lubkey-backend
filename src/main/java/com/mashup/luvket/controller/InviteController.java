package com.mashup.luvket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.luvket.domain.user.dto.TokenDto;
import com.mashup.luvket.domain.user.dto.UserDto;
import com.mashup.luvket.domain.user.service.InviteService;
import com.mashup.luvket.model.LuvketResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/invites")
public class InviteController {

	private final InviteService inviteService;

	@PostMapping("")
	public ResponseEntity<LuvketResponse<TokenDto>> createInviteToken(@RequestHeader String uid) {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(LuvketResponse.<TokenDto>builder()
					.code(HttpStatus.OK.value())
					.message("초대 토큰 생성 성공")
					.data(inviteService.createInviteToken(uid))
					.build());
	}

	@GetMapping("/{token}")
	public ResponseEntity<LuvketResponse<UserDto>> getInvitingUser(@PathVariable String token) {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(LuvketResponse.<UserDto>builder()
						.code(HttpStatus.OK.value())
						.message("초대한 사용자 정보")
						.data(inviteService.getInvitingUser(token))
						.build());
	}

	@PostMapping("/{token}/accept")
	public ResponseEntity<LuvketResponse<Void>> acceptInivte(@RequestHeader String uid,
			@PathVariable(value = "token") String token) {

		inviteService.acceptInvite(uid, token);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(LuvketResponse.<Void>builder()
						.code(HttpStatus.CREATED.value())
						.message("초대 수락 성공")
						.build());
	}
}
