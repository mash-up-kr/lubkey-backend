package com.mashup.luvket.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.mashup.luvket.domain.user.entity.InviteToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenUtils {

	public static String generate(String key, int length) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashInBytes = md.digest(key.getBytes(StandardCharsets.UTF_8));

			// bytes to hex
			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}

			return sb.toString().substring(0, length).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			log.error("token generate fail", e);
			// TODO exception 정의가 필요함
			throw new RuntimeException();
		}
	}

	public static String generateInviteToken() {
		return generate(Long.toString(System.currentTimeMillis()), InviteToken.INVITE_TOKEN_LENGTH);
	}

}
