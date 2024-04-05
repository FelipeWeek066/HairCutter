package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.repositories.ClientRepository;
import com.Felipe.HairCutter.services.exceptions.ContentNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ContentNotFoundException(id));
	}

	public Client insert(@Valid Client client) {
		return repository.save(client);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public Client update(Long id, @Valid Client obj) {
		Client client = findById(id);
		updateData(client, obj);
		return repository.save(client);
	}

	private void updateData(Client client, Client obj) {
		client.setPhone(obj.getPhone());
		client.setName(obj.getName());

	}

}
