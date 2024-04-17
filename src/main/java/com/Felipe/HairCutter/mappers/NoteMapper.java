package com.Felipe.HairCutter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Felipe.HairCutter.entities.Note;
import com.Felipe.HairCutter.entities.DTOs.NoteDTO;

@Mapper
public interface NoteMapper {
	NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);
	
	@Mapping(target = "deleted", ignore = true)
	Note noteDTOToNote(NoteDTO barber);
	
	NoteDTO noteToNoteDTO(Note barber);
}
