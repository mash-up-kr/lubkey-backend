package com.mashup.luvket.domain.luvket.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.luvket.domain.constant.status.Status;
import com.mashup.luvket.domain.luvket.entity.Luvket;

public interface LuvketRepository extends JpaRepository<Luvket, Long> {

	List<Luvket> findByUserIdInAndTitleStartsWithAndCategoryIdInAndStatusAndPublicOpen(Set<Long> userIds, String title,
			Set<Long> categoryIds, Status status, boolean isPublicOpen, Pageable pageable);

}
