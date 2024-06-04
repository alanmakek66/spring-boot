package com.bootcamp.demo_public_transportation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.demo_public_transportation.transportationEntity.TransprotationEntity;
import com.bootcamp.demo_public_transportation.transportationEntity.ValueEntity;

public interface ValueRepository extends JpaRepository<ValueEntity,String> {
  
}
