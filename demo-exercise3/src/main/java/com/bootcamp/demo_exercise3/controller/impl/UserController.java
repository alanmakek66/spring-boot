package com.bootcamp.demo_exercise3.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_exercise3.controller.UserOperation;
import com.bootcamp.demo_exercise3.dto.PostandCommentDto;
import com.bootcamp.demo_exercise3.dto.UserDto;
import com.bootcamp.demo_exercise3.dto.mapper.PostandCommentDtoMapper;
import com.bootcamp.demo_exercise3.dto.mapper.PostandCommentEntityMapper;
import com.bootcamp.demo_exercise3.dto.mapper.UserandPostandComDtoMapper;
import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.entity.commentEntity.mapper.CommentEntityMapper;
import com.bootcamp.demo_exercise3.entity.postEntity.PostAndCommnetEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.infa.ApiResp;
import com.bootcamp.demo_exercise3.service.CommentService;
import com.bootcamp.demo_exercise3.service.PostService;
import com.bootcamp.demo_exercise3.service.UserService;

@RestController
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;
  @Autowired 
  private PostService postService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private PostandCommentEntityMapper postandCommentEntityMapper;
  @Autowired
  private UserandPostandComDtoMapper userandPostandComDtoMapper;
  @Autowired
  private PostandCommentDtoMapper postandCommentDtoMapper;
  
  

  @Override
  public ApiResp<UserDto> getallUser(){
    List<UserEntity> userEntities =userService.getUserEntity();
    List<PostEntity> postEntities =postService.getPostEntity();
    List<CommentEntity> commentEntities=commentService.getCommentEntity();
    List<PostAndCommnetEntity> list1=
    postandCommentEntityMapper.map(postEntities, commentEntities);

    List<PostandCommentDto> postandCommentDtos=list1.stream()
    .map(e->postandCommentDtoMapper.map(e)).collect(Collectors.toList());
    //List<UserDto>
    return 
    ApiResp.<UserDto> builder()
    .id("00000")
    .message("SUCCESS.")
    .data(userandPostandComDtoMapper.map(userEntities, postandCommentDtos))
    .build();
    
    
    
    //userandPostandComDtoMapper.map(userEntities, postandCommentDtos);
}

@Override
public ApiResp<UserDto> getusserByid(String id) {
  List<UserDto> result=new ArrayList<>(List.of(userService.getUserById(id)));
  return ApiResp.<UserDto>builder()
  //
  .id("000000")
  .message("SUCCESS.")
  .data(result)//
  .build();
}

@Override
public ApiResp<UserEntity> putUser(String id, UserEntity userEntity){
  return 
  ApiResp.<UserEntity>builder()
  //userService.putUser(id, userEntity);
  .id("000000")
  .message("SUCCESS.")
  .data(List.of(userService.putUser(id, userEntity)))//
  .build();
}
  
}
