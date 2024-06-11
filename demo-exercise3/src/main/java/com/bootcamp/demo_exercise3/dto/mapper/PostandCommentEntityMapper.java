package com.bootcamp.demo_exercise3.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3.dto.PostandCommentDto;
import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.PostAndCommnetEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;

@Component
public class PostandCommentEntityMapper {
  public  List<PostAndCommnetEntity> map(List<PostEntity> postEntities
  ,List<CommentEntity> commentEntities){
    return postEntities.stream().map(post->{
      List<CommentEntity> test1=commentEntities.stream()
      .filter(c->c.getPostEntity().getId().equals(post.getId())).collect(Collectors.toList());

      

      return PostAndCommnetEntity.builder().id(post.getId()).title(post.getTitle())
      .body(post.getBody()).userEntity(post.getUserEntity()).commentEntities(test1).build();
    }).collect(Collectors.toList());
  }
  
  
}
