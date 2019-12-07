package com.mashup.luvket.domain.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.luvket.domain.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
