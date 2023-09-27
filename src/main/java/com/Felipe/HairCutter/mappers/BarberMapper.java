package com.Felipe.HairCutter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.DTOs.BarberDTO;

@Mapper
public interface BarberMapper {
	BarberMapper INSTANCE = Mappers.getMapper(BarberMapper.class);
	
	@Mapping(target = "orders", ignore = true)
	Barber barberDTOToBarber(BarberDTO barber);
	
	BarberDTO barberToBarberDTO(Barber barber);
}
