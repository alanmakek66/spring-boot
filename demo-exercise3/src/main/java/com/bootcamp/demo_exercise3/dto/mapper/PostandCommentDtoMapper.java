package com.bootcamp.demo_exercise3.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3.dto.CommentDto;
import com.bootcamp.demo_exercise3.dto.PostandCommentDto;
import com.bootcamp.demo_exercise3.entity.postEntity.PostAndCommnetEntity;

@Component
public class PostandCommentDtoMapper {
  public PostandCommentDto map(PostAndCommnetEntity postAndCommnetEntities){
    
    List<CommentDto> commentDtos=  postAndCommnetEntities.getCommentEntities()
    .stream().map(e-> new CommentDto().builder().id(e.getId()).body(e.getBody())
    .name(e.getName()).email(e.getEmail()).build()).collect(Collectors.toList());

 return PostandCommentDto.builder().id(postAndCommnetEntities.getId())
 .userId(postAndCommnetEntities.getUserEntity().getId())
    .body(postAndCommnetEntities.getBody()).title(postAndCommnetEntities.getTitle())
    .commentDtos(commentDtos).build();
  }
  
}
