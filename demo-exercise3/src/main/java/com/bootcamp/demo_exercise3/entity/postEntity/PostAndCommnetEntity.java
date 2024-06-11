package com.bootcamp.demo_exercise3.entity.postEntity;

import java.util.List;

import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class PostAndCommnetEntity {
  private Long id;
  private String title;
  private String body;
  private List<CommentEntity> commentEntities;
  private UserEntity userEntity;
  
}
