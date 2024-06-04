package com.bootcamp.demo_allinone.dto.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_allinone.dto.UserDto;
import com.bootcamp.demo_allinone.dto.UserDto.Companydto;
import com.bootcamp.demo_allinone.model.User;

@Component
public class UserDtoMapper {
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
