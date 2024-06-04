package com.example.demo_student1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_student1.model.Subject1;
import com.example.demo_student1.service.StudentService;

@RestController
public class StudentController implements StudentOperation {

  @Autowired
  private StudentService ss1;

  @Override

  public List<Subject1> getSubject1(@RequestParam String name){
    return ss1.getSubjectByname(name);

  }
  @Override
  public int getsize(){
    return ss1.getSize();
  }


  
}
