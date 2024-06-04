package com.bootcamp.demo_stock2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.bootcamp.demo_stock2.model.Stock;
import com.bootcamp.demo_stock2.model.User;

import jakarta.annotation.PostConstruct;

@Configuration
public class SaveDate {
  private final List<User> users =new ArrayList<>();

  public List<User> getUserList(){
    return this.users;
  }

  @PostConstruct
  public void init(){
    Stock s1= new Stock(1000);
    Stock s2= new Stock(3000);

   User u1=new User("SAM");
   User u2=new User("TOM");
   User u3=new User("Jenny");

   u1.add(s1);
   u1.add(s2);
   u2.add(s1);
   u2.add(s1);
   u3.add(s2);

   users.add(u1);
   users.add(u2);
   users.add(u3);
  }

  
}
