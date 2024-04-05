package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE client SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NonNull
	@NotNull
	@Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]*$", message = "apenas letras e espaços")
	private String name;
	
	@NonNull
	@Pattern(regexp = "^[0-9()+\\s]*$", message = "formato invalido")
	private String phone;
	
	@Setter(value = AccessLevel.NONE)
	@ToString.Exclude
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Set<HairJobOrder> orders = new HashSet<>();
	
	@Setter(value = AccessLevel.NONE)
	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "client_notes", 
		joinColumns = {@JoinColumn(name = "client_id")},
		inverseJoinColumns = {@JoinColumn(name = "note_id")}
	)
	private Set<Note> notes = new HashSet<>();
	private boolean deleted;
}
