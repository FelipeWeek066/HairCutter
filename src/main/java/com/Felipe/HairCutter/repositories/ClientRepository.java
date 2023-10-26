package com.Felipe.HairCutter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.entities.HairJobOrder;

public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("SELECT c.orders FROM Client c WHERE c.id = :clientId")
	List<HairJobOrder> findOrdersById(@Param("clientId") Long clientId);
}
