package com.bootcamp.demo_allinone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_allinone.UserEntity.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity,Long> {
  
}
