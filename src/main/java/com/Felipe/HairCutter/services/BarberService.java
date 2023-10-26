package com.Felipe.HairCutter.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.History;
import com.Felipe.HairCutter.enums.Status;
import com.Felipe.HairCutter.repositories.BarberRepository;
import com.Felipe.HairCutter.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class BarberService {
	@Autowired
	private BarberRepository repository;

	public List<Barber> findAll() {
		return repository.findAll();
	}

	public Barber findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Barber insert(@Valid Barber barber) {
		barber.getHistory().add(new History(Status.ativo, LocalDate.now(), "Barbeiro ativado."));
		return repository.save(barber);
	}

	public void delete(Long id) {
		Barber barber = findById(id);
		if(repository.findOrdersById(id).isEmpty()) {
			repository.deleteById(id);
		}else {
			barber.getHistory().add(new History(Status.inativo, LocalDate.now(), "Barbeiro desativado."));
			repository.save(barber);
		}
	}

	public Barber update(Long id, @Valid Barber obj) {
		findById(id);
		Barber barber = findById(id);
		updateData(barber, obj);
		return repository.save(barber);
	}

	private void updateData(Barber barber, Barber obj) {
		barber.setName(obj.getName());
		barber.getHistory().add(new History(Status.ativo, LocalDate.now(), "Os dados foram atualizados."));

	}
}
