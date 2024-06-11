package com.bootcamp.demo_exercise3b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_exercise3b.entity.PhotoEntity;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity,Long> {
  
}
