package com.bootcamp.demo_restful.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_restful.Dto.UserDto;
import com.bootcamp.demo_restful.Dto.requestDto.UserRequestDto;
import com.bootcamp.demo_restful.UserEntitys.UserEntity;
import com.bootcamp.demo_restful.UserEntitys.UserEntityDto;
import com.bootcamp.demo_restful.infa.ApiResp;
import com.bootcamp.demo_restful.infa.NotFoundException;
import com.bootcamp.demo_restful.model.modelDto.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserOperation {

  @GetMapping(value = "/jsonplaceholder/users")
  List<UserDto> getUsers() throws JsonProcessingException;

  @GetMapping(value = "/save/usersdto")
  List<UserDto> save()throws JsonProcessingException;

  @GetMapping(value = "/save/users")
  List<User> save2() throws JsonProcessingException;

  @GetMapping(value = "/po")
  List<UserDto> po();

  @GetMapping(value = "/po2")
  List<User> po2();

  @PostMapping(value = "/user")
  UserEntity saveUser(@RequestBody UserEntity u1);

  @PostMapping(value = "/put/all/user")
  List<UserEntity> fromApiToDb();

  @DeleteMapping(value = "/user")
  UserEntity delet(@RequestParam Long id)throws NotFoundException;

  @PutMapping(value = "/user") //更新
  ApiResp<UserEntity> updateUser(@RequestParam Long id,@RequestBody UserEntity user)
  throws NotFoundException;

  @GetMapping(value = "/user/id")
  ApiResp<UserEntity> getuserByid(@RequestParam Long id)throws NotFoundException;

  @GetMapping(value = "/user/phone")
  ApiResp<UserEntity> getuserByPhone(@RequestParam  String phone)throws NotFoundException;

  @GetMapping(value = "/user/Lat/Long")
  ApiResp<UserEntity> getUserByAddrLatAndaddrLong(@RequestParam String addrLat,@RequestParam String addrLong)
  throws NotFoundException;

  @PatchMapping(value = "/user/email")
  UserEntity updateUserEmailById(@RequestParam Long id,
   @RequestBody UserRequestDto userRequestDto);


 




  
}
