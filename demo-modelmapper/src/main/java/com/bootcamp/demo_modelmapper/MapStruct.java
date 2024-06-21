package com.bootcamp.demo_modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bootcamp.demo_modelmapper.dto.UserDto;
import com.bootcamp.demo_modelmapper.model.User;

@Mapper
public interface MapStruct {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "username", target = "username")
  UserDto map(User u1);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "username", target = "username")
  User map(UserDto u2);

}
