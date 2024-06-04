package com.example.demo_student1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo_student1.model.Subject1;

public interface StudentOperation {
  @GetMapping(value = "/subject")
  List<Subject1> getSubject1(@RequestParam String name);

  @GetMapping(value = "/size")
  int getsize();

  
}
