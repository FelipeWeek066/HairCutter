package com.Felipe.HairCutter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Felipe.HairCutter.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
	
}
