package com.Felipe.HairCutter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Felipe.HairCutter.entities.HairJob;

public interface HairJobRepository extends JpaRepository<HairJob, Long>{
	
}
