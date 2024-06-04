package com.bootcamp.demo_restful.service;

import java.util.List;

import com.bootcamp.demo_restful.Dto.requestDto.UserRequestDto;
import com.bootcamp.demo_restful.UserEntitys.UserEntity;
import com.bootcamp.demo_restful.UserEntitys.UserEntityDto;
import com.bootcamp.demo_restful.infa.NotFoundException;
import com.bootcamp.demo_restful.model.modelDto.User;

public interface UserService {
  List<User> getUser();

  UserEntity saveUserEntity(UserEntity u1);

  List<UserEntity> saveApiToDataBase();

  UserEntity deletByid(Long id) throws NotFoundException;

  UserEntity update(Long id, UserEntity user) throws NotFoundException;

  UserEntity getUserById(Long id) throws NotFoundException;

  List<UserEntity> getUserByPhone(String phone) throws NotFoundException;

  List<UserEntity> getUserByAddrLatAndaddrLong(String addrLat,String addrLong) throws NotFoundException;

  UserEntity updateEmailById(Long id, UserRequestDto dto) throws NotFoundException;
  
}
