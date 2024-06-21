package com.bootcamp.demo_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_register.model.User;

@Repository
public interface UserRepsitory extends JpaRepository<User,Long> {
  User findByUsername(String username);
  
}
