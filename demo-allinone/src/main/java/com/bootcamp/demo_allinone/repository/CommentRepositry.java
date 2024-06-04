package com.bootcamp.demo_allinone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_allinone.CommentEntity.CommentEntity;
@Repository
public interface CommentRepositry extends JpaRepository<CommentEntity,Long> {
  
}
