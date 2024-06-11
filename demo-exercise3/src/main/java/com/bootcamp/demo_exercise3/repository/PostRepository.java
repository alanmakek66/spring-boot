package com.bootcamp.demo_exercise3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
  
}
