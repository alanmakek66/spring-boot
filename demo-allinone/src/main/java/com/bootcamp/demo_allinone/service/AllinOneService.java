package com.bootcamp.demo_allinone.service;

import java.util.List;

import com.bootcamp.demo_allinone.CommentEntity.CommentEntity;
import com.bootcamp.demo_allinone.UserEntity.UserEntity;
import com.bootcamp.demo_allinone.ablumEntity.AblumEntity;
import com.bootcamp.demo_allinone.model.Album;
import com.bootcamp.demo_allinone.model.User;
import com.bootcamp.demo_allinone.postEntity.PostEntity;
import com.bootcamp.demo_allinone.todosEntity.TodosEntity;

public interface AllinOneService {
  List<User> getUsers();
  List<UserEntity> getUsersAndSave();
  List<AblumEntity> getAblumAndSave();
  List<PostEntity> getPostAndSave();
  List<TodosEntity> getTodosAndSave();
  List<CommentEntity> getCommentAndSave();

  
}
