package com.Felipe.HairCutter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Felipe.HairCutter.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
