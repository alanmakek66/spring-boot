package com.example.demo_student1.datasave;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.example.demo_student1.model.Student;
import com.example.demo_student1.model.Subject1;

import jakarta.annotation.PostConstruct;

@Controller
public class config {
  public static List<Student> database= new ArrayList<>();

  @PostConstruct
  public void initdata() {
    List<Subject1> ss = new ArrayList<>(List.of(Subject1.Chinese, Subject1.English, Subject1.Maths));
    
    Student s1 = new Student("TOM", ss);
    Student s2 = new Student("FUNG", ss);
    Student s3 = new Student("KEN", ss);
    
    config.database.add(s3);
    config.database.add(s2);
    config.database.add(s1);

  }
  public List<Student> getdatabase(){
    return this.database;
  }

}
