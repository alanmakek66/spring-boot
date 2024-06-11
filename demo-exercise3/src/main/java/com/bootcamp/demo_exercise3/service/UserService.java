package com.bootcamp.demo_exercise3.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_exercise3.dto.UserDto;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;

public interface UserService {
  List<UserEntity> getUserEntity();
  UserDto getUserById(String id);
  UserEntity putUser(String id,UserEntity userEntity);
  
}
