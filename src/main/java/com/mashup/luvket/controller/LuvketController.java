package com.mashup.luvket.controller;

import com.mashup.luvket.domain.luvket.dto.LuvketDto;
import com.mashup.luvket.domain.luvket.service.LuvketService;
import com.mashup.luvket.model.LuvketResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mashup.luvket.domain.luvket.LuvketPageRequest;
import com.mashup.luvket.domain.luvket.dto.LuvketCreateDto;
import com.mashup.luvket.domain.luvket.entity.Luvket;
import com.mashup.luvket.domain.luvket.repository.LuvketRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/luvkets")
@RestController
public class LuvketController {

	private final LuvketRepository luvketRepository;

    private final LuvketService luvketService;

	@PostMapping("")
	public void create(@RequestBody LuvketCreateDto luvketCreateDto) {
		Luvket luvket = Luvket.create(luvketCreateDto.getTitle(), luvketCreateDto.getMemo());

		luvketRepository.save(luvket);
	}

	@GetMapping("")
	public ResponseEntity<LuvketResponse<List<LuvketDto>>> search(@RequestHeader String uid,
			LuvketPageRequest luvketPageRequest) {

		List<LuvketDto> luvkets = luvketService.get(uid, luvketPageRequest);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(LuvketResponse.<List<LuvketDto>>builder()
						.code(HttpStatus.OK.value())
						.message("럽킷 목록 조회")
						.data(luvkets)
						.build());
	}
}
