package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.Felipe.HairCutter.enums.Day;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
//entity for a day of the week.
public class WeekDay implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Enumerated(EnumType.STRING)
	private Day dayName;
	
	@Setter(value = AccessLevel.NONE)
	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "day&notes", 
			joinColumns = {@JoinColumn(name = "day_id")},
			inverseJoinColumns = {@JoinColumn(name = "note_id")}
		)
	private Set<Note> notes = new HashSet<>();
	
}
