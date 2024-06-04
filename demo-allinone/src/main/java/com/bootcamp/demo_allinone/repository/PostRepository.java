package com.bootcamp.demo_allinone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_allinone.postEntity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,String> {
  
}
