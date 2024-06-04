package com.bootcamp.demo_stock2;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bootcamp.demo_stock2.controller.Stock2Controller;
import com.bootcamp.demo_stock2.dto.Stockdto2;
import com.bootcamp.demo_stock2.model.Stock;
import com.bootcamp.demo_stock2.service.Stock2Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(Stock2Controller.class)
public class StockControllerTest {
  
@Autowired
  private MockMvc mm1;

  @MockBean
  private Stock2Service s2s;

  @Test
  public void test1() throws Exception{
    Stock s1=new Stock(500);
    Stock s2=new Stock(1500);


    Mockito.when(s2s.getStocks()).thenReturn(new ArrayList<>(List.of(s1,s2)));
    
    mm1.perform(MockMvcRequestBuilders.get("/getsumofstock"))
    .andExpect(MockMvcResultMatchers.jsonPath("$[0].stockId", is(1)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity",is(500)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[1].stockId", is(2)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity", is(1500)));

    mm1.perform(MockMvcRequestBuilders.get("/getsumofstock"))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].stockId", hasItem(1)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].stockId", hasItem(2)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].quantity", hasItem(500)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*].quantity", hasItem(1500)));

    String json1 =mm1.perform(get("/getsumofstock"))
    .andReturn().getResponse().getContentAsString();

    Stockdto2[] test11= new ObjectMapper().readValue(json1, Stockdto2[].class);
    
    List<Stockdto2> tt= Arrays.asList(test11);
    assertThat(tt, hasItem(new Stockdto2(1, 500)));

    
    
    
    
  }
  
}
