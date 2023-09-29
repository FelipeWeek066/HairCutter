package com.Felipe.HairCutter.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.DTOs.BarberDTO;
import com.Felipe.HairCutter.mappers.BarberMapper;
import com.Felipe.HairCutter.services.BarberService;

@RestController
@RequestMapping(value = "/Barbers")
public class BarberResource {
	@Autowired
	private BarberService service;
	
	@GetMapping
	public  ResponseEntity<List<Barber>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Barber> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Barber> insert(@RequestBody BarberDTO obj){
		Barber barber = new Barber(obj.getName());
		service.insert(barber);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(barber.getId()).toUri();
		return ResponseEntity.created(uri).body(barber);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody BarberDTO dto){
		service.update(id, BarberMapper.INSTANCE.barberDTOToBarber(dto));
		return ResponseEntity.noContent().build();
	}
	
	
}
