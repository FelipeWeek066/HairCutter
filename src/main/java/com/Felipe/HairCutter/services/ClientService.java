package com.Felipe.HairCutter.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.entities.History;
import com.Felipe.HairCutter.enums.Status;
import com.Felipe.HairCutter.repositories.ClientRepository;
import com.Felipe.HairCutter.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Client insert(@Valid Client client) {
		client.getHistory().add(new History(Status.ativo, LocalDate.now(), "Cliente ativado."));
		return repository.save(client);
	}

	public void delete(Long id) {
		Client client = findById(id);
		if (repository.findOrdersById(id).isEmpty()) {
			repository.deleteById(id);
		} else {
			client.getHistory().add(new History(Status.inativo, LocalDate.now(), "Cliente desativado."));
			repository.save(client);
		}
	}

	public Client update(Long id, @Valid Client obj) {
		Client client = findById(id);
		updateData(client, obj);
		return repository.save(client);
	}

	private void updateData(Client client, Client obj) {
		client.setPhone(obj.getPhone());
		client.setName(obj.getName());
		client.getHistory().add(new History(Status.ativo, LocalDate.now(), "Os dados foram atualizados."));

	}

}
