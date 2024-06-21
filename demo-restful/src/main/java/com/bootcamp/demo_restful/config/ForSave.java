package com.bootcamp.demo_restful.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.bootcamp.demo_restful.Dto.UserDto;
import com.bootcamp.demo_restful.helper.RedisHelper;
import com.bootcamp.demo_restful.model.modelDto.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;

@Configuration
@Getter
public class ForSave {
  private List<User> users=new ArrayList<>();
  private List<UserDto> userdtos=new ArrayList<>();

// different between using ReisTemplate and Restemplate
// 1. you need to define the key, value types for RedisTemplate.class
// 2. there are set() and get() method in redisTemplate Object. You have to do
// serialization and deserialization yourself.


  @Bean 
  public ObjectMapper objectMapper(){
    return new ObjectMapper();
  }
  @Bean
  RedisHelper redisHelper(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisHelper(factory, objectMapper);
  }

  
}
