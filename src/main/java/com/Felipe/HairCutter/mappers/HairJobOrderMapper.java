package com.Felipe.HairCutter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.Felipe.HairCutter.entities.HairJobOrder;
import com.Felipe.HairCutter.entities.DTOs.HairJobOrderDTO;

@Mapper(uses = {ClientMapper.class, BarberMapper.class})
public interface HairJobOrderMapper {
	HairJobOrderMapper INSTANCE = Mappers.getMapper(HairJobOrderMapper.class);
	
	HairJobOrder hairJobOrderDTOToHairJobOrder(HairJobOrderDTO client);
	
	HairJobOrderDTO hairJobOrderToHairJobOrderDTO(HairJobOrder client);
}
