package com.bootcamp.demo_allinone.postEntity.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_allinone.model.Post;
import com.bootcamp.demo_allinone.postEntity.PostEntity;

@Component
public class PostEntityMapper {

  public PostEntity map(Post p1){
    return PostEntity.builder()
    .id(p1.getId())
    .userId(p1.getUserId())
    .title(p1.getTitle())
    .body(p1.getBody())
    .build();
  }
  
}
