package com.Felipe.HairCutter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Felipe.HairCutter.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
