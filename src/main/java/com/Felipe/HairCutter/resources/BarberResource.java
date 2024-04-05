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

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.DTOs.BarberDTO;
import com.Felipe.HairCutter.mappers.BarberMapper;
import com.Felipe.HairCutter.services.BarberService;

@RestController
@RequestMapping(value = "/Barbers")
public class BarberResource {
	@Autowired
	private BarberService barberService;
	
	@GetMapping
	public ResponseEntity<List<BarberDTO>> findAll(){
		//transform to DTO.
		return ResponseEntity.ok().body(barberService.findAll().stream().map(x -> BarberMapper.INSTANCE.barberToBarberDTO(x)).toList());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BarberDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(BarberMapper.INSTANCE.barberToBarberDTO(barberService.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<BarberDTO> insertBarber(@RequestBody BarberDTO barber){
		return ResponseEntity.ok().body(
				BarberMapper.INSTANCE.barberToBarberDTO(
						barberService.insert(BarberMapper.INSTANCE.barberDTOToBarber(barber))
						)
				);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<BarberDTO> updateBarber(@PathVariable Long id, @RequestBody Barber barber){
		return ResponseEntity.ok().body(BarberMapper.INSTANCE.barberToBarberDTO(barberService.update(id, barber)));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Barber> updateBarber(@PathVariable Long id){
		barberService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
