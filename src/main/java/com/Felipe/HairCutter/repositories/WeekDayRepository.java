package com.Felipe.HairCutter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Felipe.HairCutter.entities.WeekDay;

public interface WeekDayRepository extends JpaRepository<WeekDay, Long>{
	
}
