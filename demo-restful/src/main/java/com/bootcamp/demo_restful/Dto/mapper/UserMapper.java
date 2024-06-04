package com.bootcamp.demo_restful.Dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_restful.Dto.UserDto;
import com.bootcamp.demo_restful.Dto.UserDto.Companydto;
import com.bootcamp.demo_restful.model.modelDto.User;
import com.bootcamp.demo_restful.service.UserService;

@Component
public class UserMapper {

  public UserDto maptoUserDto(User u1) {

    Companydto cdo = Companydto.builder()
        .name(u1.getCompany().getName())
        .catchPhrase(u1.getCompany().getCatchPhrase())
        .business(u1.getCompany().getBusiness())
        .build();

    return UserDto.builder()
        .id(u1.getId())
        .name(u1.getName())
        .company(cdo)
        .build();

  }

}
