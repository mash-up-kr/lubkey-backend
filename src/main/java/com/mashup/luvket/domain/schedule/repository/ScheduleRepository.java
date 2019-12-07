package com.mashup.luvket.domain.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.luvket.domain.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
