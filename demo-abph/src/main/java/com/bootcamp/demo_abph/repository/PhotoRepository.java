package com.bootcamp.demo_abph.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_abph.photoEntity.PhotoEntity;
@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity,String> {

  @Query("select e from PhotoEntity e where e.title like %:str%")
  Optional<List<PhotoEntity>> findBytitle(@Param("str") String str);
  
  
}
