package com.Felipe.HairCutter.entities.DTOs;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String note;
	private LocalDate date;
	
}
