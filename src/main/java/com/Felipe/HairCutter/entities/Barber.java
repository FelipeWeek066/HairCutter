package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Barber implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	@NotNull
	@NonNull
	@Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]*$", message = "apenas letras e espaços")
	private String name;
	@Setter(value = AccessLevel.NONE)
	@ToString.Exclude
	@OneToMany(mappedBy = "barber", fetch = FetchType.LAZY)
	//if we use List here, a circular Error appear, this doesn't happen with Set or with a @JsonIgnore.
	private Set<HairJobOrder> orders = new HashSet<>();
	

}
