package com.bootcamp.demo_allinone.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_allinone.CommentEntity.CommentEntity;
import com.bootcamp.demo_allinone.UserEntity.UserEntity;
import com.bootcamp.demo_allinone.ablumEntity.AblumEntity;
import com.bootcamp.demo_allinone.controller.AllinOneOperation;
import com.bootcamp.demo_allinone.dto.UserDto;
import com.bootcamp.demo_allinone.dto.Mapper.UserDtoMapper;
import com.bootcamp.demo_allinone.model.User;
import com.bootcamp.demo_allinone.postEntity.PostEntity;
import com.bootcamp.demo_allinone.service.AllinOneService;
import com.bootcamp.demo_allinone.todosEntity.TodosEntity;

@RestController
public class AllinOneController implements AllinOneOperation {

  @Autowired
  private AllinOneService aioservice;

  @Autowired
  private UserDtoMapper udm1;

  @Override
  public List<UserDto> getUsers(){
    return aioservice.getUsers().stream().map(e->udm1.maptoUserDto(e)).collect(Collectors.toList());
  }

  @Override
  public List<UserEntity> getUsersAndSave(){
    return aioservice.getUsersAndSave();
 }
 @Override
 public List<AblumEntity> getAblumAndSave(){
  return aioservice.getAblumAndSave();
 }
 @Override
 public List<PostEntity> getPostAndSave(){
  return aioservice.getPostAndSave();
 }
 @Override
 public List<TodosEntity> getTodosAndSave(){
  return aioservice.getTodosAndSave();
 }

 @Override
 public List<CommentEntity> getCommentAndSave(){
  return aioservice.getCommentAndSave();
 }
  
}
