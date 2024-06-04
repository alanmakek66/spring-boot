package com.bootcamp.demo_restful.UserEntitys.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_restful.UserEntitys.UserEntity;
import com.bootcamp.demo_restful.UserEntitys.UserEntityDto;
import com.bootcamp.demo_restful.model.modelDto.User;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor


public class UserEntityDtoMapper {

  public UserEntity map(User u1){
    return UserEntity.builder()
    .name(u1.getName())
    .username(u1.getUsername())
    .email(u1.getEmail())
    .addrStreet(u1.getAddress().getStreet())
    .addrSuite(u1.getAddress().getSuite())
    .addrcity(u1.getAddress().getCity())
    .addrzipcode(u1.getAddress().getZipcode())
    .addrLat(u1.getAddress().getGeo().getLat())
    .addrLong(u1.getAddress().getGeo().getLng())
    .companyBs(u1.getCompany().getBusiness())
    .phone(u1.getPhone())
    .build();

  }
  
}
