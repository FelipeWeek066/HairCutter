package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.repositories.BarberRepository;
import com.Felipe.HairCutter.services.exceptions.ContentNotFoundException;

import jakarta.validation.Valid;

@Service
public class BarberService {
	@Autowired
	private BarberRepository repository;

	public List<Barber> findAll() {
		return repository.findAll();
	}

	public Barber findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ContentNotFoundException(id));
	}

	public Barber insert(@Valid Barber barber) {
		return repository.save(barber);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public Barber update(Long id, Barber obj) {
		Barber barber = findById(id);
		updateData(barber, obj);
		return repository.save(barber);
	}

	private void updateData(Barber barber, Barber obj) {
		barber.setName(obj.getName());
	}
}
