package com.Felipe.HairCutter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.entities.DTOs.ClientDTO;

@Mapper
public interface ClientMapper {
	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
	
	@Mapping(target = "orders", ignore = true)
	@Mapping(target = "notes", ignore = true)
	@Mapping(target = "deleted", ignore = true)
	Client clientDTOToClient(ClientDTO client);
	
	ClientDTO clientToClientDTO(Client client);
}
