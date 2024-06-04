package com.example.demo_student1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_student1.datasave.config;
import com.example.demo_student1.model.Subject1;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private config c1;

  @Override
  public List<Subject1> getSubjectByname(String name){
    List<Subject1> s1=new ArrayList<>();
    for(int i=0;i<c1.getdatabase().size();i++){
      if(name.equals(c1.getdatabase().get(i).getName())){
        s1=c1.getdatabase().get(i).getSubjects();

      }
    }return s1;
}

@Override
    public int getSize(){
      return c1.getdatabase().size();
      
    }


  

  
  
}
