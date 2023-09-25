package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HairJobOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "barber_id")
	@ManyToOne
	private Barber barber;
	@JoinColumn(name = "client_id")
	@ManyToOne
	private Client client;
	private Instant instant;
	@Setter(value = AccessLevel.NONE)
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
	@JoinTable(name = "Order_HairJob", 
	joinColumns = {@JoinColumn(name = "hairJob_id")},
	inverseJoinColumns = {@JoinColumn(name = "hairJobOrder_id")}
	)
	private List<HairJob> jobs = new ArrayList<>();
	
}
