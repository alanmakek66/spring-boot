package com.bootcamp.demo_exercise3.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_exercise3.controller.PostOperation;
import com.bootcamp.demo_exercise3.dto.PostDto;
import com.bootcamp.demo_exercise3.dto.PostandCommentDto;
import com.bootcamp.demo_exercise3.dto.mapper.PostandCommentDtoMapper;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.infa.ApiResp;
import com.bootcamp.demo_exercise3.service.PostService;

@RestController
public class PostController implements PostOperation {

  @Autowired
  private PostandCommentDtoMapper postandCommentDtoMapper;
  @Autowired
  private PostService postService;

  @Override
  public ApiResp<PostandCommentDto> getAllpost() {
    return 
    ApiResp.<PostandCommentDto>builder()
    .id("000000")
    .message("SUCCESS")
    .data( postService.getPostAndCommnetEntities().stream().map(e -> postandCommentDtoMapper.map(e))
    .collect(Collectors.toList()))
    .build();
    
    
    /* postService.getPostAndCommnetEntities().stream().map(e -> postandCommentDtoMapper.map(e))
        .collect(Collectors.toList()); */

  }
  @Override 
  public ApiResp<PostandCommentDto> getPostByid(String id){
    //postandCommentDtoMapper.map(postService.getPostByid(id));
   
    return 
    ApiResp.<PostandCommentDto>builder()
    .id("000000")
    .message("SUCCESS")
    .data(List.of(postandCommentDtoMapper.map(postService.getPostByid(id))))
    .build();
    //postandCommentDtoMapper.map(postService.getPostByid(id));

  }
  @Override
  public ApiResp<PostEntity> addPostByuserId(@PathVariable String id,PostEntity postEntity){
    return
    ApiResp.<PostEntity> builder()
    .id("000000")
    .message("success")
    .data(List.of(postService.addPostByuserId(id, postEntity)))
    .build();
     //postService.addPostByuserId(id, postEntity);
  }
  @Override
  public ApiResp<PostEntity> deletePostByid(@PathVariable String id){
    return ApiResp.<PostEntity>builder()
    .id("000000")
    .message("success")
    .data(List.of(postService.deletePostByid(id)))
    .build();
    
   //postService.deletePostByid(id);
  }

}
