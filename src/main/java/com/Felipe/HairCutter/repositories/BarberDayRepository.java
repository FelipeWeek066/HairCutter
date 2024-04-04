package com.Felipe.HairCutter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Felipe.HairCutter.entities.BarberDay;

public interface BarberDayRepository extends JpaRepository<BarberDay, Long>{
	
}
