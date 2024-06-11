package com.bootcamp.demo_exercise3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_exercise3.dto.UserDto;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.infa.ApiResp;

public interface UserOperation {

 @GetMapping(value = "/all/user")
 ApiResp<UserDto> getallUser();

  @GetMapping(value = "/id/user")
  ApiResp<UserDto> getusserByid(@RequestParam String id);

  /* @GetMapping(value = "/id/user")
  UserDto getusserByid(@RequestParam String id); */

  @PutMapping(value = "/put/user")
  ApiResp<UserEntity> putUser(@RequestParam String id, @RequestBody UserEntity userEntity);
  
}
