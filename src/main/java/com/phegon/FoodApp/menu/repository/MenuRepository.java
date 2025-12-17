package com.phegon.FoodApp.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.phegon.FoodApp.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu>{

}
