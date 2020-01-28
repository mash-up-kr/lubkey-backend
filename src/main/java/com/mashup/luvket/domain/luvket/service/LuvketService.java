package com.mashup.luvket.domain.luvket.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mashup.luvket.domain.constant.status.Status;
import com.mashup.luvket.domain.luvket.LuvketPageRequest;
import com.mashup.luvket.domain.luvket.dto.LuvketDto;
import com.mashup.luvket.domain.luvket.entity.Luvket;
import com.mashup.luvket.domain.luvket.repository.LuvketRepository;
import com.mashup.luvket.domain.user.service.UserService;
import com.mashup.luvket.domain.user.service.UserToUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LuvketService {

	private final LuvketRepository luvketRepository;
	private final UserService userService;
	private final UserToUserService userToUserService;

	private static final int PAGE_SIZE = 25;

	public List<LuvketDto> get(String uid, LuvketPageRequest luvketPageRequest) {
		int page = luvketPageRequest.getPage();

		Set<Long> userIds = getUserIds(uid);
		String title = luvketPageRequest.getTitle();
		Set<Long> categoryIds = luvketPageRequest.getCategoryIds();
		Status status = luvketPageRequest.getStatus();
		boolean isPublicOpen = luvketPageRequest.isPublic();

		// TODO index 추가 필요
		List<Luvket> luvkets = luvketRepository.findByUserIdInAndTitleStartsWithAndCategoryIdInAndStatusAndPublicOpen(
				userIds, title, categoryIds, status, isPublicOpen, PageRequest.of(page, PAGE_SIZE));

		return luvkets.stream().map(LuvketDto::of).collect(Collectors.toList());
	}

	private Set<Long> getUserIds(String uid) {
		Long userId = userService.getUser(uid).getId();
		return userToUserService.getUserIds(userId);
	}
}
