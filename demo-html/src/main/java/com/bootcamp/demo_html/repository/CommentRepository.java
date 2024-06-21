package com.bootcamp.demo_html.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_html.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
  
}
