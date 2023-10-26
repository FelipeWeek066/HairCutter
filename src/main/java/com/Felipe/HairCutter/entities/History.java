package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.Felipe.HairCutter.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class History implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@NotNull
	private Status status;
	@NonNull
	@NotNull
	private LocalDate date;
	@NonNull
	@NotNull
	private String description;
}
