package com.bootcamp.demo_spe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.bootcamp.demo_spe1.infra.NotFoundException;
import com.bootcamp.demo_spe1.service.CalculatorService;


@WebMvcTest(CalculatorService.class)

public class CalculatorServiceTest {

  @Autowired
  private CalculatorService ccs1;

  /* @BeforeAll
  public void setup(){
    ccs1 =new CalculatorServiceimpl();
  }
 */


  @Test
  public void testCaculate(){
    
    Assertions.assertEquals("333.0", ccs1.Caculate("111", "222", "add"));
    Assertions.assertEquals("-111.0", ccs1.Caculate("111", "222", "sub"));
    Assertions.assertEquals("24642.0", ccs1.Caculate("111", "222", "mul"));
    Assertions.assertEquals("0.5", ccs1.Caculate("111", "222", "div"));

    Assertions.assertEquals("error", ccs1.Caculate("abc", "222", "div"));
    Assertions.assertEquals("error", ccs1.Caculate("111", "abc", "div"));
    Assertions.assertEquals("error", ccs1.Caculate("111", "222", "ddd"));
    
  }
  @Test
  public void testCaculate2() throws NotFoundException {
    
    Assertions.assertEquals("333.0", ccs1.Caculate("111", "222", "add"));
    Assertions.assertEquals("-111.0", ccs1.Caculate("111", "222", "sub"));
    Assertions.assertEquals("24642.0", ccs1.Caculate("111", "222", "mul"));
    Assertions.assertEquals("0.5", ccs1.Caculate("111", "222", "div"));

    Assertions.assertThrows(NotFoundException.class, () -> ccs1.Caculate2("111", "222", "ddd"));
    Assertions.assertThrows(NumberFormatException.class, () -> ccs1.Caculate2("1a1a1", "222", "div"));
    Assertions.assertThrows(NumberFormatException.class, () -> ccs1.Caculate2("111", "2a2a", "div"));

    //Assertions.assertEquals("error", ccs1.Caculate2("111", "222", "div"));
    //Assertions.assertEquals("error", ccs1.Caculate2("111", "222", "div"));
    //Assertions.assertEquals(new NotFoundException(), ccs1.Caculate2("111", "222", "ddd"));
    
  }

  
}
