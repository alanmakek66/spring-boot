package com.bootcamp.demo_bc_yahoo_finance.bench;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.bootcamp.demo_bc_yahoo_finance.holiday.Holiday;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class RedisBean {
  
  @Bean
  public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
    RedisTemplate<String,String> redisTemplate=new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    return  redisTemplate;
  }
  @Bean
  public Holiday holiday(){
    return new Holiday();
  }
 
}
