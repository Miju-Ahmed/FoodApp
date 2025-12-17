package com.phegon.FoodApp.role.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phegon.FoodApp.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByName(String Name);
    

}
