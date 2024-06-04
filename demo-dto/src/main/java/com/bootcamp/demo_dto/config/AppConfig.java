package com.bootcamp.demo_dto.config;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bootcamp.demo_dto.dto.StockDto;
import com.bootcamp.demo_dto.dto.mapper.StockMapper;
import com.bootcamp.demo_dto.model.Stock;
import com.bootcamp.demo_dto.model.User;

import jakarta.annotation.PostConstruct;
import lombok.ToString;


@Configuration
@ToString
public class AppConfig {
  @Autowired
   private StockMapper sm1;
 
  private final List<User> users = new ArrayList<>();

  @Bean
  public  StockDto map(Stock s1){
    return StockDto.builder()
    .stockNo(s1.getId())
    .quantity(s1.getQuantity())
    .build();
  }
  
  
  public List<User> getUsers() {
    return this.users;
  }

  @PostConstruct
  public void dummyUsers() {
    User userA = new User();
    userA.add(new Stock(5, "ABC", 1000));
    User userB = new User();
    userB.add(new Stock(5, "ABC", 20000));
    User userC = new User();
    userC.add(new Stock(10, "DEV", 20));
    users.add(userA);
    users.add(userB);
    users.add(userC);
  }
  
}
