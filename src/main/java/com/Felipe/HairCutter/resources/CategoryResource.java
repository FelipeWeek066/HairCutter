package com.Felipe.HairCutter.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Felipe.HairCutter.entities.Category;
import com.Felipe.HairCutter.entities.DTOs.CategoryDTO;
import com.Felipe.HairCutter.mappers.CategoryMapper;
import com.Felipe.HairCutter.services.CategoryService;

@RestController
@RequestMapping(value = "/Categories")
public class CategoryResource {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		// transform to DTO.
		return ResponseEntity.ok()
				.body(categoryService.findAll().stream().map(x -> CategoryMapper.INSTANCE.categoryToCategoryDTO(x)).toList());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(CategoryMapper.INSTANCE.categoryToCategoryDTO(categoryService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO category) {
		return ResponseEntity.ok().body(CategoryMapper.INSTANCE
				.categoryToCategoryDTO(categoryService.insert(CategoryMapper.INSTANCE.categoryDTOToCategory(category))));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody Category category) {
		return ResponseEntity.ok().body(CategoryMapper.INSTANCE.categoryToCategoryDTO(categoryService.update(id, category)));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
