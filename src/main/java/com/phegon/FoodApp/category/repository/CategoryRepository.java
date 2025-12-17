package com.phegon.FoodApp.category.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.phegon.FoodApp.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    

}
