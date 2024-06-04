package com.example.demo_student1.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;

@Getter
public class Student {

  private static final AtomicLong count = new AtomicLong(0);

  private long id;
  private String name;
  private List<Subject1> subjects;

  public Student(String name,List<Subject1> subjects){
    this.id=count.incrementAndGet();
    this.name=name;
    this.subjects=subjects;


  }
  
}
