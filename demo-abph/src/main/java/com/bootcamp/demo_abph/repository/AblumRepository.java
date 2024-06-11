package com.bootcamp.demo_abph.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_abph.ablumEntity.AblumEntity;

@Repository
public interface AblumRepository extends JpaRepository<AblumEntity,String> {

  @Query ("select e from AblumEntity e where e.userId=:userId")
  Optional<List<AblumEntity>> findByUserId(@Param("userId")String userId);
  
}
