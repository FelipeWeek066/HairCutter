package com.Felipe.HairCutter.entities.DTOs;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import com.Felipe.HairCutter.entities.HairJob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private ClientDTO client;
	private BarberDTO barber;
	private Instant instant;
	private List<HairJob> jobs;

}
