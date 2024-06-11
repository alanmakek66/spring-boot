package com.bootcamp.demo_exercise3.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.bootcamp.demo_exercise3.entity.postEntity.PostAndCommnetEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;

public interface PostService {

  List<PostEntity> getPostEntity();
  List<PostAndCommnetEntity> getPostAndCommnetEntities();
  PostAndCommnetEntity getPostByid(String id);
  PostEntity addPostByuserId(  String id,PostEntity postEntity);
  PostEntity deletePostByid(String id);
  
  
}
