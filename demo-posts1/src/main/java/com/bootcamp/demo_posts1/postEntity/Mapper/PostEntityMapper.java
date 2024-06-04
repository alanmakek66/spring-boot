package com.bootcamp.demo_posts1.postEntity.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_posts1.model.Post;
import com.bootcamp.demo_posts1.postEntity.PostEntity;

@Component
public class PostEntityMapper {

  public PostEntity map(Post p1){
    return PostEntity.builder()
    .userId(p1.getUserId())
    .id(p1.getId())
    .body(p1.getBody())
    .build();
  }
  
}
