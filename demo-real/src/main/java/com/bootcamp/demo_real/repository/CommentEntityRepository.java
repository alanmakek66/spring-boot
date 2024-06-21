package com.bootcamp.demo_real.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_real.entity.CommentEntity;

@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity,Long> {
  
}
