package com.mashup.luvket.domain.category;

import com.mashup.luvket.domain.category.entity.Category;

import lombok.Getter;

@Getter
public class CategoryDto {
	
	private Long id;
	private String name;
	
	public CategoryDto(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

}
