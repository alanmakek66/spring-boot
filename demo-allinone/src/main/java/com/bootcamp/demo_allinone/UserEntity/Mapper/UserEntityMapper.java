package com.bootcamp.demo_allinone.UserEntity.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_allinone.UserEntity.UserEntity;
import com.bootcamp.demo_allinone.model.User;

@Component
public class UserEntityMapper {
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
    .phone(u1.getPhone())
    .website(u1.getWebsite())
    .companyName(u1.getCompany().getName())
    .companycatchPhrase(u1.getCompany().getCatchPhrase())
    .companyBs(u1.getCompany().getBusiness())
    .build();
    

  }
  
}
