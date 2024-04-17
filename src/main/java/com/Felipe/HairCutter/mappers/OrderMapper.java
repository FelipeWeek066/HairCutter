package com.Felipe.HairCutter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Felipe.HairCutter.entities.Order;
import com.Felipe.HairCutter.entities.DTOs.OrderDTO;

@Mapper(uses = {ClientMapper.class, BarberMapper.class})
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	

	@Mapping(target = "deleted", ignore = true)
	@Mapping(target = "notes", ignore = true)
	Order orderDTOToOrder(OrderDTO client);
	
	OrderDTO orderToOrderDTO(Order client);
}
