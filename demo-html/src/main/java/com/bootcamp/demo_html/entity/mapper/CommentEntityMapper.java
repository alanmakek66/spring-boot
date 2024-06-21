package com.bootcamp.demo_html.entity.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_html.entity.CommentEntity;

import com.bootcamp.demo_html.model.Comment;

@Component
public class CommentEntityMapper {
  public CommentEntity map(Comment m1){
    return CommentEntity.builder()
    .commnet(m1.getComment1())
    .build();
  }
  
}
