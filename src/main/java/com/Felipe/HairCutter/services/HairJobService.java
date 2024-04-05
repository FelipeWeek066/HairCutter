package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.HairJob;
import com.Felipe.HairCutter.repositories.HairJobRepository;
import com.Felipe.HairCutter.services.exceptions.DatabaseException;
import com.Felipe.HairCutter.services.exceptions.ContentNotFoundException;

import jakarta.validation.Valid;

@Service
public class HairJobService {
	@Autowired
	private HairJobRepository repository;
	
	public List<HairJob> findAll(){
		return repository.findAll();
	}
	
	public HairJob findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ContentNotFoundException(id));
	}
	
	public HairJob insert(@Valid HairJob hairJob) {
		return repository.save(hairJob);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			}catch (DataIntegrityViolationException e) {
				throw new DatabaseException("couldn't delete the hair Job, theres some reference in database");
			}
	}
	
	public HairJob update(Long id, @Valid HairJob obj) {
		HairJob hairJob = findById(id);
		updateData(hairJob, obj);
		return repository.save(hairJob);
	}

	private void updateData(HairJob hairJob, HairJob obj) {
		hairJob.setCategory(obj.getCategory());
		hairJob.setName(obj.getName());
		hairJob.setPrice(obj.getPrice());
	}
	
	
}
