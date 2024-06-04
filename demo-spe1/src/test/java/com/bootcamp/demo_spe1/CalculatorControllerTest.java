package com.bootcamp.demo_spe1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.bootcamp.demo_spe1.controller.impl.CalculatorController;
import com.bootcamp.demo_spe1.infra.NotFoundException;
import com.bootcamp.demo_spe1.model.Calculator;
import com.bootcamp.demo_spe1.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.hamcrest.MatcherAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.skyscreamer.jsonassert.JSONAssert;



@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

  @MockBean
  private CalculatorService ccss;

  @Autowired
  private MockMvc mm;

  @Autowired
private ObjectMapper objectMapper;

  @Test
  public void testc1() throws Exception {
    Mockito.when(ccss.Caculate("11", "11", "add")).thenReturn("1");

    mm.perform(MockMvcRequestBuilders.get("/calculate?x=11&y=11&operation=add"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.x", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.y", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operation", is("add")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result", is("1")));

    Mockito.when(ccss.Caculate("22", "22", "add")).thenReturn("error");
    mm.perform(MockMvcRequestBuilders.get("/calculate?x=22&y=22&operation=add"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.code", is(9)))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message", is("Invaild input")));

  }

  @Test
  public void test4() throws Exception {
    Mockito.when(ccss.Caculate2("11", "11", "add")).thenReturn("22");

    String jsonResponse = "{\"x\":\"11\",\"y\":\"11\",\"operation\":\"add\",\"result\":\"22\"}";

    JSONAssert.assertEquals("{\"x\":\"11\",\"y\":\"11\",\"operation\":\"add\",\"result\":\"22\"}", jsonResponse, true);
  }

  @Test
  public void test3() throws Exception {
    Mockito.when(ccss.Caculate2("11", "11", "add")).thenReturn("1");

    mm.perform(MockMvcRequestBuilders.get("/c2?x=11&y=11&operation=add"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.x", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.y", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operation", is("add")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result", is("1")));

    // Mockito.verify(ccss,times(1).description("aaaa"));

  }

  @Test
  public void test5() throws Exception {
    Mockito.when(ccss.Caculate2(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
        .thenThrow(new NotFoundException());

    mm.perform(MockMvcRequestBuilders.get("/c2?x=11&y=11&operation=add"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.code", is(99)))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message", is("Invaild input")));

  }

  @Test
  public void test6() throws Exception {
    Mockito.when(ccss.Caculate2("11", "11", "add")).thenReturn("1");
    mm.perform(MockMvcRequestBuilders.post("/p1?x=11&y=11&operation=add"))
    .andExpect(MockMvcResultMatchers.jsonPath("$.x", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.y", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operation", is("add")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result", is("1")));

  }
  @Test
  public void test7() throws Exception {
    Mockito.when(ccss.Caculate2("11", "11", "add")).thenReturn("1");

    Calculator c1=new Calculator("11", "11", "add");
    String requestBody = objectMapper.writeValueAsString(c1);


    ResultActions resultActions = mm.perform(MockMvcRequestBuilders.post("/p2")
                                             .content(requestBody)
                                             .contentType(MediaType.APPLICATION_JSON));

    // Assert
    resultActions
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.x", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.y", is("11")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operation", is("add")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result", is("1")));
    
    

  }
}
