package com.example.demo_student1;



import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;



import com.example.demo_student1.datasave.config;


@WebMvcTest(config.class)

public class configTest {
  
 @Autowired
private config c1; 

//@MockBean
//private config c1; //會取代原本main 內的bean;

@Test
public void testinit(){
  Assertions.assertEquals(3, c1.getdatabase().size());
   //union test
}


  

    


  

 
  
}
