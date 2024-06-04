package com.bootcamp.demo_dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bootcamp.demo_dto.config.AppConfig;
import com.bootcamp.demo_dto.model.Stock;
import com.bootcamp.demo_dto.model.User;
import com.bootcamp.demo_dto.service.StockService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
public class StockServiceTest {

  @MockBean
  private AppConfig aa1;

  @Autowired
  private StockService ss1;

  @Test
  void testSave(){
    Stock s1=new Stock(1, "999", 5);
    User u1=new User();
    User u2 =new User();
    List<User> uu11=new ArrayList<>(List.of(u1,u2));

    Mockito.when(aa1.getUsers()).thenReturn(uu11);

    ss1.save(s1, 1);
    

    assertThat(u1.getStocks().size(), is(1));



  }
  
}
