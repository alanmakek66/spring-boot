package com.bootcamp.demo_allinone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_allinone.todosEntity.TodosEntity;

@Repository
public interface TodosRepository extends JpaRepository<TodosEntity,Long> {
  
}
