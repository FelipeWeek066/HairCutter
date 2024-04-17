package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Order;
import com.Felipe.HairCutter.repositories.OrderRepository;
import com.Felipe.HairCutter.services.exceptions.ContentNotFoundException;

import jakarta.validation.Valid;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ContentNotFoundException(id));
	}
	
	public Order insert(@Valid Order hJO) {
		return repository.save(hJO);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Order update(Long id, @Valid Order obj) {
		Order hJO = findById(id);
		updateData(hJO, obj);
		return repository.save(hJO);
	}

	private void updateData(Order hJO, Order obj) {
		hJO.setClient(obj.getClient());
		hJO.setBarber(obj.getBarber());
		hJO.setInstant(obj.getInstant());
		hJO.getJobs().clear();
		hJO.getJobs().addAll(obj.getJobs());
	}
	
	
}
