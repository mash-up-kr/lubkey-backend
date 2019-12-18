package com.mashup.luvket.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mashup.luvket.domain.user.entity.InviteToken;

public class TokenUtilsTest {

	@Test
	public void test_generateInviteToken() {
		String inviteToken = TokenUtils.generateInviteToken();

		assertEquals(InviteToken.INVITE_TOKEN_LENGTH, inviteToken.length());
	}

}
