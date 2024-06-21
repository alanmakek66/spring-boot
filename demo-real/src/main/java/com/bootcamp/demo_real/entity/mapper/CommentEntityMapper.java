package com.bootcamp.demo_real.entity.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_real.entity.CommentEntity;
import com.bootcamp.demo_real.model.Comment1;


@Component
public class CommentEntityMapper {

  public CommentEntity map(Comment1 c1){
    return CommentEntity.builder()
    .comment(c1.getComment())
    .build();

  }
  
}
