package com.bootcamp.demo_dto;



import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import com.bootcamp.demo_dto.controller.StockController;
import com.bootcamp.demo_dto.model.Stock;
import com.bootcamp.demo_dto.service.StockService;


@WebMvcTest(StockController.class)
public class StockControllerTest {

  @MockBean
  private StockService s11;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testGetStock()throws Exception{
    Stock s1= new Stock(5, "abc", 1000);
    Stock s2= new Stock(5, "abc", 1200);
    Stock s3= new Stock(10, "abc", 5000);

    Mockito.when(s11.getAll()).thenReturn(new ArrayList<>(List.of(s1,s2,s3)));



    mockMvc.perform(MockMvcRequestBuilders.get("/stocs"))
    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id",is(5)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity",is(3000)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", is(10)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity",is(2000)));

    mockMvc.perform(MockMvcRequestBuilders.get("/stocks"))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].stockNo", hasItem(5)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].quantity", hasItem(3000)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].stockNo", hasItem(10)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].quantity", hasItem(2000)));

  }

 
  
}
