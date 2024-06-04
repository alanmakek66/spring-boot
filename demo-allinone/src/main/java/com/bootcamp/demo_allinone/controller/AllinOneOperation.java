package com.bootcamp.demo_allinone.controller;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.demo_allinone.CommentEntity.CommentEntity;
import com.bootcamp.demo_allinone.UserEntity.UserEntity;
import com.bootcamp.demo_allinone.ablumEntity.AblumEntity;
import com.bootcamp.demo_allinone.dto.UserDto;
import com.bootcamp.demo_allinone.model.User;
import com.bootcamp.demo_allinone.postEntity.PostEntity;
import com.bootcamp.demo_allinone.todosEntity.TodosEntity;

public interface AllinOneOperation {

  @GetMapping(value = "/users")
 List<UserDto> getUsers();

 @PostMapping(value = "/users/save")
 List<UserEntity> getUsersAndSave();

 @PostMapping(value = "/ablum/save")
 List<AblumEntity> getAblumAndSave();

 @PostMapping(value = "/post/save")
 List<PostEntity> getPostAndSave();

 @PostMapping(value = "/todos/save")
 List<TodosEntity> getTodosAndSave();

 @PostMapping(value = "/comment/save")
 List<CommentEntity> getCommentAndSave();

  
}
