package com.mashup.luvket.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.luvket.domain.luvket.dto.LuvketCreateDto;
import com.mashup.luvket.domain.luvket.entity.Luvket;
import com.mashup.luvket.domain.luvket.repository.LuvketRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/luvket")
@RestController
public class LuvketController {

	private final LuvketRepository luvketRepository;

	@PostMapping("/")
	public void create(@RequestBody LuvketCreateDto luvketCreateDto) {
		Luvket luvket = Luvket.create(luvketCreateDto.getTitle(), luvketCreateDto.getMemo());

		luvketRepository.save(luvket);
	}

}
