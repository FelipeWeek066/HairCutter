package com.Felipe.HairCutter.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.repositories.ClientRepository;
import com.Felipe.HairCutter.services.exceptions.DatabaseException;
import com.Felipe.HairCutter.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client insert(@Valid Client client) {
		client.setEnterDate(LocalDate.now());
		return repository.save(client);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
			}catch (DataIntegrityViolationException e) {
				throw new DatabaseException("couldn't delete the Client, there some references in database");
			}
	}
	
	public Client update(Long id, @Valid Client obj) {
		findById(id);
		Client client = repository.getReferenceById(id);
		updateData(client, obj);
		return repository.save(client);
	}

	private void updateData(Client client, Client obj) {
		client.setPhone(obj.getPhone());
		client.setName(obj.getName());
	}
	
	
}
