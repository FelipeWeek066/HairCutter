package com.Felipe.HairCutter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Felipe.HairCutter.entities.HairJobOrder;

public interface HairJobOrderRepository extends JpaRepository<HairJobOrder, Long>{

}
