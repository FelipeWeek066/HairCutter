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

import com.Felipe.HairCutter.entities.HairJob;
import com.Felipe.HairCutter.entities.DTOs.HairJobDTO;
import com.Felipe.HairCutter.mappers.HairJobMapper;
import com.Felipe.HairCutter.services.HairJobService;

@RestController
@RequestMapping(value = "/HairJobs")
public class HairJobResouorce {
	@Autowired
	private HairJobService hairJobService;

	@GetMapping
	public ResponseEntity<List<HairJobDTO>> findAll() {
		// transform to DTO.
		return ResponseEntity.ok()
				.body(hairJobService.findAll().stream().map(x -> HairJobMapper.INSTANCE.hairJobToHairJobDTO(x)).toList());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<HairJobDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(HairJobMapper.INSTANCE.hairJobToHairJobDTO(hairJobService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<HairJobDTO> insertHairJob(@RequestBody HairJobDTO hairJob) {
		return ResponseEntity.ok().body(HairJobMapper.INSTANCE
				.hairJobToHairJobDTO(hairJobService.insert(HairJobMapper.INSTANCE.hairJobDTOToHairJob(hairJob))));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<HairJobDTO> updateHairJob(@PathVariable Long id, @RequestBody HairJob hairJob) {
		return ResponseEntity.ok().body(HairJobMapper.INSTANCE.hairJobToHairJobDTO(hairJobService.update(id, hairJob)));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HairJob> updateHairJob(@PathVariable Long id) {
		hairJobService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
