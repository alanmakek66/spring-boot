package com.bootcamp.demo_exercise3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_exercise3.controller.impl.UserController;
import com.bootcamp.demo_exercise3.dto.UserDto;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.infa.NotFoundException;
import com.bootcamp.demo_exercise3.repository.UserRepository;
import com.bootcamp.demo_exercise3.service.UserService;

@Service
public class UserServiceimpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  @Lazy
  private UserController userController;

  @Override
  public List<UserEntity> getUserEntity() {
    return userRepository.findAll();
  }
  @Override
  public UserDto getUserById(String id){
    try{
      Long iid=Long.valueOf(id);
 }catch(NumberFormatException n){
      throw new NumberFormatException();
    }
    Long iid=Long.valueOf(id);
    return userController.getallUser().getdata().stream().filter(e->e.getId().equals(iid))
    .findFirst().orElseThrow(()->new NotFoundException());
    
}
@Override
public UserEntity putUser( String id, UserEntity userEntity){
  try{
    Long iid=Long.valueOf(id);
}catch(NumberFormatException n){
    throw new NumberFormatException();
  }
  Long iid=Long.valueOf(id);
  if(!(userEntity.getId().equals(iid))){
    throw new NotFoundException();
  } userRepository.save(userEntity);
  return userEntity;



}
  
}
