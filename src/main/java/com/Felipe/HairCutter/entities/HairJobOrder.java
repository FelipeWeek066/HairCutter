package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class HairJobOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@NotNull
	@ManyToOne
	@JoinColumn(name = "barber_id")
	private Barber barber;
	@NotNull
	@NonNull
	@JoinColumn(name = "client_id")
	@ManyToOne
	private Client client;
	@NonNull
	@NotNull
	private Instant instant;
	@Setter(value = AccessLevel.NONE)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Order_HairJob", 
	joinColumns = {@JoinColumn(name = "hairJob_id")},
	inverseJoinColumns = {@JoinColumn(name = "hairJobOrder_id")}
	)
	private List<HairJob> jobs = new ArrayList<>();
	
}
