package com.mashup.luvket.controller;

import com.mashup.luvket.domain.luvket.dto.LuvketDto;
import com.mashup.luvket.domain.luvket.service.LuvketService;
import com.mashup.luvket.model.LuvketResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import com.mashup.luvket.domain.luvket.dto.LuvketCreateDto;
import com.mashup.luvket.domain.luvket.entity.Luvket;
import com.mashup.luvket.domain.luvket.repository.LuvketRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/luvket")
@RestController
public class LuvketController {

	private final LuvketRepository luvketRepository;

    private final LuvketService luvketService;

	@PostMapping("/")
	public void create(@RequestBody LuvketCreateDto luvketCreateDto) {
		Luvket luvket = Luvket.create(luvketCreateDto.getTitle(), luvketCreateDto.getMemo());

		luvketRepository.save(luvket);
	}

    @GetMapping("")
    public LuvketResponse<List<LuvketDto>> search(@PageableDefault(size = 25)
                                                  @SortDefault.SortDefaults({
                                                          @SortDefault(sort = "status", direction = Sort.Direction.DESC),
                                                          @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                                                  })
                                                          Pageable pageable){
        return luvketService.search(pageable);
    }
}
