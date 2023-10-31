package com.Felipe.HairCutter.entities.pk;

import java.io.Serializable;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.WeekDay;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BarberDayPK implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "barber_id")
	private Barber barber;
	@ManyToOne
	@JoinColumn(name = "weekDay_id")
	private WeekDay weekDay;
}
