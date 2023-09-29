package com.Felipe.HairCutter.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Felipe.HairCutter.entities.Barber;
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
	
	
}
