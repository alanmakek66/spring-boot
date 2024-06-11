package com.bootcamp.demo_exercise3.dto.mapper;

import org.springframework.stereotype.Component;


import com.bootcamp.demo_exercise3.dto.CommentDto;
import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;

@Component
public class CommentDtoMapper {
  public CommentDto map(CommentEntity commentEntity){
    return CommentDto.builder()
    .id(commentEntity.getId()).postId(commentEntity.getPostEntity().getId())
    .body(commentEntity.getBody())
    .name(commentEntity.getName()).email(commentEntity.getEmail()).build();
  }
  
}
