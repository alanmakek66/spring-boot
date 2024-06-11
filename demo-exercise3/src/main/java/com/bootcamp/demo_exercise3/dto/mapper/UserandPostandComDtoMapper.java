package com.bootcamp.demo_exercise3.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3.dto.AddressDto;
import com.bootcamp.demo_exercise3.dto.CommentDto;
import com.bootcamp.demo_exercise3.dto.CompanyDto;
import com.bootcamp.demo_exercise3.dto.LocationDto;
import com.bootcamp.demo_exercise3.dto.PostDto;
import com.bootcamp.demo_exercise3.dto.PostandCommentDto;
import com.bootcamp.demo_exercise3.dto.UserDto;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.UserandPostEntity;
import com.bootcamp.demo_exercise3.model.User.Company;

@Component
public class UserandPostandComDtoMapper {

  public List<UserDto> map(List<UserEntity> userEntities
  ,List<PostandCommentDto> postandCommentDtos){
    
    return userEntities.stream().map(e->{
      List<PostandCommentDto> tset1=postandCommentDtos.stream().filter(x->x.getUserId()
      .equals(e.getId())).collect(Collectors.toList());

      CompanyDto companyDto= CompanyDto.builder().name(e.getCompanyName())
      .catchPhrase(e.getCompanyCatchPhrase()).business(e.getCompanyBS()).build();

      LocationDto locationDto=LocationDto.builder().lat(e.getAddrLat()).lng(e.getAddrLong()).build();

      AddressDto addressDto=AddressDto.builder().city(e.getAddrCity()).street(e.getAddrStreet())
      .zipcode(e.getAddrZipcode()).suite(e.getAddrSuite()).geo(locationDto).build();

      return UserDto.builder().id(e.getId()).name(e.getName()).username(e.getUsername())
      .website(e.getWebsite()).phone(e.getPhone()).company(companyDto).addressdto(addressDto)
      .PostAndCommentDto(tset1).email(e.getEmail())
      .build();
    }).collect(Collectors.toList());
 }
  }
  

