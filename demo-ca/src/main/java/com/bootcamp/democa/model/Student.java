package com.bootcamp.democa.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString



public class Student extends Person{
  private String name;
  public static List<Student> studentDB =new ArrayList<>();
  


  public Student(int StudentId,String name){
    super(StudentId);
    this.name=name;
  }
  
}
