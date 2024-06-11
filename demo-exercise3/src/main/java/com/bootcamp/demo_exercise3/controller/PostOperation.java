package com.bootcamp.demo_exercise3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bootcamp.demo_exercise3.dto.PostDto;
import com.bootcamp.demo_exercise3.dto.PostandCommentDto;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.infa.ApiResp;
import com.bootcamp.demo_exercise3.model.Post;

public interface PostOperation {


  @GetMapping(value = "/all/post")
  ApiResp<PostandCommentDto> getAllpost();
  //List<PostandCommentDto> getAllpost();

  @GetMapping(value = "/id/post/{id}")
  ApiResp<PostandCommentDto> getPostByid(@PathVariable String id);

  @PostMapping(value = "/add/post/{id}")
  ApiResp<PostEntity> addPostByuserId(@PathVariable String id,@RequestBody PostEntity postEntity);

  @PostMapping(value = "delete/post/{id}")
  ApiResp<PostEntity> deletePostByid(@PathVariable String id);
  
}
