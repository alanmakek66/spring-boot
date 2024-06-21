package com.bootcamp.demo_html.entity.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_html.entity.PersonEntity;
import com.bootcamp.demo_html.model.Person;

@Component
public class PersonEntityMapper {
  public PersonEntity map(Person p1){
    return PersonEntity.builder()
    .name(p1.getName())
    .password(p1.getPassword())
    .build();
  }
  
}
