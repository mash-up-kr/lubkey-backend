package com.mashup.luvket.domain.category.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mashup.luvket.domain.category.CategoryDto;
import com.mashup.luvket.domain.category.repository.CategoryRepository;
import com.mashup.luvket.domain.constant.status.Status;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public List<CategoryDto> getAll() {

		return categoryRepository.findAll()
				.stream()
				.filter(c -> Status.OK == c.getStatus())
				.map(CategoryDto::new)
				.collect(Collectors.toList());
	}
}
