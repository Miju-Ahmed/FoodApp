package com.phegon.FoodApp.auth_users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phegon.FoodApp.auth_users.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
