package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Note;
import com.Felipe.HairCutter.repositories.NoteRepository;
import com.Felipe.HairCutter.services.exceptions.ContentNotFoundException;

import jakarta.validation.Valid;

@Service
public class NoteService {
	@Autowired
	private NoteRepository repository;
	
	public List<Note> findAll(){
		return repository.findAll();
	}
	
	public Note findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ContentNotFoundException(id));
	}
	
	public Note insert(@Valid Note hJO) {
		return repository.save(hJO);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Note update(Long id, @Valid Note obj) {
		Note hJO = findById(id);
		updateData(hJO, obj);
		return repository.save(hJO);
	}

	private void updateData(Note hJO, Note obj) {
		hJO.setDate(obj.getDate());
		hJO.setNote(obj.getNote());
	}
	
	
}
