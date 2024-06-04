package com.example.demo_student1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.example.demo_student1.datasave.config;
import com.example.demo_student1.model.Student;
import com.example.demo_student1.model.Subject1;
import com.example.demo_student1.service.StudentService;
import com.example.demo_student1.service.StudentServiceImpl;

@WebMvcTest(StudentService.class)
public class StudentServiceTest {

  @Autowired
  private StudentService ss1;

  @MockBean
  private config c1;

  @Test
  public void testGetByName(){
    List<Subject1> ss = new ArrayList<>(List.of(Subject1.Chinese, Subject1.English, Subject1.Maths));
    
    Student s1 = new Student("TOM", ss);
    Student s2 = new Student("FUNG", ss);
    Student s3 = new Student("KEN", ss);


    Mockito.when(c1.getdatabase()).thenReturn(new ArrayList<>(List.of(s1,s2,s3)));

    Assertions.assertEquals(ss, ss1.getSubjectByname("TOM"));


  }
  
}
