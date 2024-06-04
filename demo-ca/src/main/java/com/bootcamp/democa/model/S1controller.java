package com.bootcamp.democa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody

public class S1controller {

  @GetMapping(value ="/addstudent")
  public String addstudent(@RequestParam String studentId,@RequestParam String name){
    try{
      int test1=Integer.valueOf(studentId);
      Student s1= new Student(test1, name);
      Student.studentDB.add(s1);
      return "add done";

    }catch(NumberFormatException n){
      return "studentId must be integer";
    }

  }

  @GetMapping(value="/getstudentlist")
  public List<Student> getStudentDB(){
    return Student.studentDB;
  }

  @GetMapping(value="/remove")
  public String removeDb(String idx){
    try{
      int test1=Integer.valueOf(idx);
      Student.studentDB.remove(test1);
      return "remove done";
    }catch(NumberFormatException n){
      return "idx must be integer";
    }catch(ArrayIndexOutOfBoundsException a){
      return "idx out of bounds";
    }
    
  }
   @GetMapping(value = "/getallstudent")
  public int[] getallstudentid(){
    return Student.studentDB.stream().mapToInt(e->e.getIdNo()).toArray();
    //Student.studentDB.stream().map(e->e.getIdNo()).collect(Collectors.toList());

  } 
  
  @GetMapping (value = "/void")
  public void testvoid(){

  }

  @GetMapping(value = "/getstudent")
  public List<Student> getStudent(@RequestParam String name){
    List<Student> test1=new ArrayList<>();
    
    for(int i=0;i<Student.studentDB.size();i++){
      if(name.equals(Student.studentDB.get(i).getName())){
        test1.add(Student.studentDB.get(i));
      }

    }return test1;

  }

  @GetMapping(value = "/getstudent2")
  public List<Student> getStudent2(@RequestParam String name){
    return Student.studentDB.stream().filter(e->name.equals(e.getName())).collect(Collectors.toList());

  }
  
  
}
