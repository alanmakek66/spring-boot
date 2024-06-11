package com.bootcamp.demo_exercise3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;

import jakarta.transaction.Transactional;




@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

  /* @Modifying
  @Transactional
  @Query("DELETE FROM CommentEntity e WHERE e.postEntity.id = :postid")
    void deleteAllByPostId(@Param("postid") Long postid); */

void deleteByPostEntityId(Long postId); 


  
}
