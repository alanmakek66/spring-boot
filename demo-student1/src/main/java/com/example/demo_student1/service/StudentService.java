package com.example.demo_student1.service;

import java.util.List;

import com.example.demo_student1.model.Subject1;

public interface StudentService  {
  List<Subject1> getSubjectByname(String name);

  int getSize();
  
}
