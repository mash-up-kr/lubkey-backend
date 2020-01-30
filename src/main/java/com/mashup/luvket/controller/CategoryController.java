package com.mashup.luvket.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.luvket.domain.category.CategoryDto;
import com.mashup.luvket.domain.category.service.CategoryService;
import com.mashup.luvket.model.LuvketResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/categories")
@RestController
public class CategoryController {

	private final CategoryService categoryService;

	@GetMapping
	public ResponseEntity<LuvketResponse<List<CategoryDto>>> getAll() {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(LuvketResponse.<List<CategoryDto>>builder()
						.code(HttpStatus.OK.value())
						.message("카테고리 정보 조회 완료")
						.data(categoryService.getAll())
						.build());
	}
}