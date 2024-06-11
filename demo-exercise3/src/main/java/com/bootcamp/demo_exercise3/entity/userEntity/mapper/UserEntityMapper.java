package com.bootcamp.demo_exercise3.entity.userEntity.mapper;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.model.User;

@Component
public class UserEntityMapper {
  public UserEntity map(User u1){
    return UserEntity.builder()
    .name(u1.getName())
    .username(u1.getUsername())
    .email(u1.getEmail())
    .addrStreet(u1.getAddress().getStreet())
    .addrSuite(u1.getAddress().getSuite())
    .addrCity(u1.getAddress().getCity())
    .addrZipcode(u1.getAddress().getZipcode())
    .addrLat(u1.getAddress().getGeo().getLat())
    .addrLong(u1.getAddress().getGeo().getLng())
    .companyBS(u1.getCompany().getBusiness())
    .phone(u1.getPhone())
    .website(u1.getWebsite())
    .companyName(u1.getCompany().getName())
    .companyCatchPhrase(u1.getCompany().getCatchPhrase())
    .build();

  
}
}
