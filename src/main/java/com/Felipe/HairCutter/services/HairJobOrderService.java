package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.HairJobOrder;
import com.Felipe.HairCutter.repositories.HairJobOrderRepository;
import com.Felipe.HairCutter.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class HairJobOrderService {
	@Autowired
	private HairJobOrderRepository repository;
	
	public List<HairJobOrder> findAll(){
		return repository.findAll();
	}
	
	public HairJobOrder findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public HairJobOrder insert(@Valid HairJobOrder hJO) {
		return repository.save(hJO);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public HairJobOrder update(Long id, @Valid HairJobOrder obj) {
		HairJobOrder hJO = findById(id);
		updateData(hJO, obj);
		return repository.save(hJO);
	}

	private void updateData(HairJobOrder hJO, HairJobOrder obj) {
		hJO.setClient(obj.getClient());
		hJO.setBarber(obj.getBarber());
		hJO.setInstant(obj.getInstant());
		hJO.getJobs().clear();
		hJO.getJobs().addAll(obj.getJobs());
	}
	
	
}
