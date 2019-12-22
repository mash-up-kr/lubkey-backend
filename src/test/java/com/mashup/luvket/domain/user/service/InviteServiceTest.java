package com.mashup.luvket.domain.user.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.mashup.luvket.domain.SpringTestSupport;
import com.mashup.luvket.domain.user.dto.UserDto;
import com.mashup.luvket.domain.user.entity.InviteToken;
import com.mashup.luvket.domain.user.entity.User;
import com.mashup.luvket.domain.user.repository.InviteTokenRepository;
import com.mashup.luvket.domain.user.repository.UserRepository;
import com.mashup.luvket.util.TokenUtils;

public class InviteServiceTest extends SpringTestSupport {

	@Autowired
	private InviteTokenRepository inviteTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private InviteService inviteService;

	private static final String INVITE_TOKEN = "A1B2C3D4E5";

	@BeforeEach
	void setUp() {
		User user = getMockUser();
		userRepository.save(user);
		
		inviteTokenRepository.save(getMockInviteToken(user));
	}

	@DisplayName("초대한 사용자 정보 조회 테스트")
	@Test
	void getInvitingUser() {
		// given
		// then
		UserDto dto = inviteService.getInvitingUser(INVITE_TOKEN);
		
		// then
		assertAll(
				() -> assertEquals("이름", dto.getName()),
				() -> assertEquals("이미지 url", dto.getProfileImageUrl()));
	}

	private InviteToken getMockInviteToken(User user) {
		return InviteToken.create(user, INVITE_TOKEN);
	}

	private User getMockUser() {
		return User.builder()
			.name("이름")
			.profileImageUrl("이미지 url")
			.build();
	}
}
