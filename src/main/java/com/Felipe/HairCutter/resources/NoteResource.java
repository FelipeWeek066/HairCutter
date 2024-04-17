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

import com.Felipe.HairCutter.entities.Note;
import com.Felipe.HairCutter.entities.DTOs.NoteDTO;
import com.Felipe.HairCutter.mappers.NoteMapper;
import com.Felipe.HairCutter.services.NoteService;

@RestController
@RequestMapping(value = "/Notes")
public class NoteResource {
	@Autowired
	private NoteService noteService;

	@GetMapping
	public ResponseEntity<List<NoteDTO>> findAll() {
		// transform to DTO.
		return ResponseEntity.ok()
				.body(noteService.findAll().stream().map(x -> NoteMapper.INSTANCE.noteToNoteDTO(x)).toList());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<NoteDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(NoteMapper.INSTANCE.noteToNoteDTO(noteService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<NoteDTO> insertNote(@RequestBody NoteDTO hairJobNote) {
		return ResponseEntity.ok().body(NoteMapper.INSTANCE
				.noteToNoteDTO(noteService.insert(NoteMapper.INSTANCE.noteDTOToNote(hairJobNote))));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @RequestBody Note hairJobNote) {
		return ResponseEntity.ok().body(NoteMapper.INSTANCE.noteToNoteDTO(noteService.update(id, hairJobNote)));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
		noteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
