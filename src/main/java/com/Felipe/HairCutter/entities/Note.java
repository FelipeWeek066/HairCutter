package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE note SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
//note entity, you can note a client, a barber, or day of the week.
public class Note implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String note;
	@NonNull
	private LocalDate date;
	private boolean deleted;
}
