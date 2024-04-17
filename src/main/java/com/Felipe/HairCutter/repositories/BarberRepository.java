package com.Felipe.HairCutter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.Order;

public interface BarberRepository extends JpaRepository<Barber, Long>{
	@Query("SELECT c.orders FROM Barber c WHERE c.id = :barberId")
    List<Order> findOrdersById(@Param("barberId") Long barberId);
}
