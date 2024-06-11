package com.bootcamp.demo_exercise3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity,Long>  {
  
}
