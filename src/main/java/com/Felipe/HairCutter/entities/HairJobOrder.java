package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "orders")
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
	@NonNull
	@NotNull
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@NonNull
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm'Z'")
	private Instant instant;
	@Setter(value = AccessLevel.NONE)
	@ManyToMany
	@JoinTable(name = "Order&Jobs", 
	joinColumns = {@JoinColumn(name = "hairJob_id")},
	inverseJoinColumns = {@JoinColumn(name = "orders_id")}
	)
	@ToString.Exclude
	private Set<HairJob> jobs = new HashSet<>();
	
	
	public Double fullPrice() {
		return jobs.stream()
	               .mapToDouble(HairJob::getPrice) 
	               .sum();
	}
}


