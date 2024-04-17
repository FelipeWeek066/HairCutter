package com.Felipe.HairCutter.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.entities.DTOs.ClientDTO;
import com.Felipe.HairCutter.mappers.ClientMapper;
import com.Felipe.HairCutter.services.ClientService;

@RestController
@RequestMapping(value = "/Clients")
public class ClientResource {
	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		// transform to DTO.
		return ResponseEntity.ok()
				.body(clientService.findAll().stream().map(x -> ClientMapper.INSTANCE.clientToClientDTO(x)).toList());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(ClientMapper.INSTANCE.clientToClientDTO(clientService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<ClientDTO> insertClient(@RequestBody ClientDTO client) {
		return ResponseEntity.ok().body(ClientMapper.INSTANCE
				.clientToClientDTO(clientService.insert(ClientMapper.INSTANCE.clientDTOToClient(client))));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody Client client) {
		return ResponseEntity.ok().body(ClientMapper.INSTANCE.clientToClientDTO(clientService.update(id, client)));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
