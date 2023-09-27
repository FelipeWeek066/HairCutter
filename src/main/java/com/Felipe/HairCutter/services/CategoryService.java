package com.Felipe.HairCutter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Felipe.HairCutter.entities.Category;
import com.Felipe.HairCutter.repositories.CategoryRepository;
import com.Felipe.HairCutter.services.exceptions.DatabaseException;
import com.Felipe.HairCutter.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(@Valid Category category) {
		return repository.save(category);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
			}catch (DataIntegrityViolationException e) {
				throw new DatabaseException("couldn't delete the Category, there some references in database");
			}
	}
	
	public Category update(Long id, @Valid Category obj) {
		findById(id);
		Category category = repository.getReferenceById(id);
		updateData(category, obj);
		return repository.save(category);
	}

	private void updateData(Category category, Category obj) {
		category.setName(obj.getName());
	}
	
	
}
