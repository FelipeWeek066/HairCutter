package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.repositories.BarberRepository;
import com.Felipe.HairCutter.services.exceptions.DatabaseException;
import com.Felipe.HairCutter.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;


@Service
public class BarberService {
	@Autowired
	private BarberRepository repository;
	
	public List<Barber> findAll(){
		return repository.findAll();
	}
	
	public Barber findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Barber insert(@Valid Barber barber) {
		return repository.save(barber);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("couldn't delete The Barber, there is some References in database.");
		}
	}
	public Barber update(Long id, @Valid Barber obj) {
		findById(id);
		Barber barber = repository.getReferenceById(id);
		updateData(barber, obj);
		return repository.save(barber);
	}

	private void updateData(Barber barber, Barber obj) {
		barber.setName(obj.getName());
	}
}
