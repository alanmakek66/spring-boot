package com.bootcamp.demo_allinone.CommentEntity.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_allinone.CommentEntity.CommentEntity;
import com.bootcamp.demo_allinone.model.Comment;

@Component
public class CommentEntityMapper {

  public CommentEntity map(Comment c1){
    return CommentEntity.builder()
    .postId(c1.getPostId())
    .name(c1.getName())
    .email(c1.getEmail())
    .body(c1.getBody())
    .build();
  }
  
}
