package com.bootcamp.demo_restful.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.bootcamp.demo_restful.Dto.UserDto;
import com.bootcamp.demo_restful.model.modelDto.User;

import lombok.Getter;

@Configuration
@Getter
public class ForSave {
  private List<User> users=new ArrayList<>();
  private List<UserDto> userdtos=new ArrayList<>();

  
}
