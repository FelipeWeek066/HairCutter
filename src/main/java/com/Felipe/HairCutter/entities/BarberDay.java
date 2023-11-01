package com.Felipe.HairCutter.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.Felipe.HairCutter.entities.pk.BarberDayPK;
import com.Felipe.HairCutter.enums.Availability;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
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
@IdClass(BarberDayPK.class)
public class BarberDay implements Serializable{
	private static final long serialVersionUID = 1L;
	@NonNull
	@Id
	@MapsId("barber_id")
    private Barber barber;
	@NonNull
	@Id
	@MapsId("weekDay_id")
    private WeekDay weekDay;
	@EqualsAndHashCode.Exclude
    @NonNull
    @Enumerated(EnumType.STRING)
    private Availability availability;
   @ToString.Exclude
	@Setter(value = AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "BarberDay&notes", 
	joinColumns = {
			@JoinColumn(name = "barberDay_id1", referencedColumnName = "barber_id"),
			@JoinColumn(name = "barberDay_id2", referencedColumnName = "weekDay_id")
			},
	inverseJoinColumns = {@JoinColumn(name = "note_id")}
)
    private Set<Note> notes = new HashSet<>();
	
}
