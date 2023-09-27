package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class HairJobOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
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
	@ManyToMany
	@JoinTable(name = "Order_HairJob", 
	joinColumns = {@JoinColumn(name = "hairJob_id")},
	inverseJoinColumns = {@JoinColumn(name = "hairJobOrder_id")}
	)
	@ToString.Exclude
	private Set<HairJob> jobs = new HashSet<>();
	
}
