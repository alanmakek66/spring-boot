package com.bootcamp.demo_allinone.todosEntity.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_allinone.model.Todos;
import com.bootcamp.demo_allinone.todosEntity.TodosEntity;

@Component
public class TodosEntityMapper {

  public TodosEntity map(Todos t1){
    return TodosEntity.builder()
    .userId(t1.getUserId())
    .title(t1.getTitle())
    .completed(t1.getCompleted())
    .build();
  }
  
}
