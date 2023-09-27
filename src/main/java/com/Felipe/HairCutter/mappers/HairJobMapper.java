package com.Felipe.HairCutter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.Felipe.HairCutter.entities.HairJob;
import com.Felipe.HairCutter.entities.DTOs.HairJobDTO;

@Mapper(uses = CategoryMapper.class)
public interface HairJobMapper {
	HairJobMapper INSTANCE = Mappers.getMapper(HairJobMapper.class);
	
	
	HairJob hairJobDTOToHairJob(HairJobDTO client);
	
	HairJobDTO hairJobToHairJobDTO(HairJob client);
}
