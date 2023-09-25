package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "apenas letras e espaços")
	private String name;
	@Pattern(regexp = "^(\\+?[0-9]{2,3})?[0-9]{2,5}-[0-9]{4}$", message = "formato invalido")
	private String phone;
	private LocalDate EnterDate;
	@Setter(value = AccessLevel.NONE)
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	
	private List<HairJobOrder> orders = new ArrayList<>();
}
