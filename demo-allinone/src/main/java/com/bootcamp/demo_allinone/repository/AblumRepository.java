package com.bootcamp.demo_allinone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_allinone.ablumEntity.AblumEntity;

@Repository
public interface AblumRepository extends JpaRepository<AblumEntity,String>{
  
}
