package com.bootcamp.demo_posts1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_posts1.postEntity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,String> {

  Optional<List<PostEntity>> findByBodyContaining(String body );
  Optional<List<PostEntity>> findByBodyLike(String body );
  
}
