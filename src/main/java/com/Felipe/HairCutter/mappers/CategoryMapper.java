package com.Felipe.HairCutter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Felipe.HairCutter.entities.Category;
import com.Felipe.HairCutter.entities.DTOs.CategoryDTO;

@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	@Mapping(target = "hairJobs", ignore = true)
	Category categoryDTOToCategory(CategoryDTO client);
	
	CategoryDTO categoryToCategoryDTO(Category client);
}
