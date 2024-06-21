package com.bootcamp.demo_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_restful.Dto.UserDto;
import com.bootcamp.demo_restful.Dto.mapper.UserMapper;
import com.bootcamp.demo_restful.Dto.requestDto.UserRequestDto;
import com.bootcamp.demo_restful.UserEntitys.UserEntity;
import com.bootcamp.demo_restful.UserEntitys.UserEntityDto;
import com.bootcamp.demo_restful.config.ForSave;
import com.bootcamp.demo_restful.controller.UserOperation;
import com.bootcamp.demo_restful.infa.ApiResp;
import com.bootcamp.demo_restful.infa.NotFoundException;
import com.bootcamp.demo_restful.model.modelDto.User;
import com.bootcamp.demo_restful.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
//@RequestMapping(value = "/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService us11;

  @Autowired
  private UserMapper umum;

  @Autowired
  private ForSave fs1;
  
  @Autowired
  private ApiResp apiResp;

  @Override
  public List<UserDto> getUsers() throws JsonProcessingException {

    return us11.getUser().stream().map(e -> umum.maptoUserDto(e))
        .collect(Collectors.toList());

  }

  @Override
  public List<UserDto> save() throws JsonProcessingException{

    fs1.getUserdtos().addAll(us11.getUser().stream().map(e -> umum.maptoUserDto(e))
        .collect(Collectors.toList()));

    return fs1.getUserdtos();

  }

  @Override
  public List<User> save2() throws JsonProcessingException{
    fs1.getUsers().addAll(us11.getUser());

    return fs1.getUsers();

  }

  @Override
  public List<UserDto> po(){
    return fs1.getUserdtos();
  }

  @Override
  public List<User> po2(){
    return fs1.getUsers();
  }

  @Override
  public UserEntity saveUser(UserEntity u1){
    return us11.saveUserEntity(u1);
  }
  @Override
  public List<UserEntity> fromApiToDb(){
    return us11.saveApiToDataBase();
  }

  @Override
  public UserEntity delet(@RequestParam Long id)throws NotFoundException{
    
    return us11.deletByid(id);

  }
  @Override
  public ApiResp<UserEntity> updateUser(@RequestParam Long id,@RequestBody UserEntity user)
  throws NotFoundException{
    

    return new ApiResp<UserEntity>(0,"ok",List.of(us11.update(id, user)));
  }

  @Override
  public ApiResp<UserEntity> getuserByid(@RequestParam Long id) throws NotFoundException{

    return new ApiResp<UserEntity>(0,"ok",List.of(us11.getUserById(id)));
    
  }

  @Override

  public ApiResp<UserEntity> getuserByPhone(@RequestParam String phone)throws NotFoundException{
    return new ApiResp<UserEntity>(0,"ok",us11.getUserByPhone(phone));
  }

  @Override
  public  ApiResp<UserEntity> getUserByAddrLatAndaddrLong(@RequestParam String addrLat,@RequestParam String addrLong)
  throws NotFoundException{
    return new ApiResp<UserEntity>(0,"ok",us11.getUserByAddrLatAndaddrLong(addrLat,addrLong));

  }

  @Override
  public UserEntity updateUserEmailById(@RequestParam Long id,
   @RequestBody UserRequestDto userRequestDto)throws NotFoundException{
    
    return us11.updateEmailById(id, userRequestDto);

   }

}
