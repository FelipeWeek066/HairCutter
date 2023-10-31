package com.Felipe.HairCutter.entities;

import java.io.Serializable;

import com.Felipe.HairCutter.entities.pk.BarberDayPK;
import com.Felipe.HairCutter.enums.Availability;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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

	
}
