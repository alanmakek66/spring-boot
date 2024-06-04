package com.bootcamp.demo_bus;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_bus.model.Data;
import com.bootcamp.demo_bus.model.KmbRoute;
import com.bootcamp.demo_bus.service.RouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RouteService.class)
public class RouteServiceTest {

  @Autowired
  private MockMvc mm1;

  @MockBean
  private RouteService rs1;

  @Test
  void testtypeCorrect() throws Exception {
    String url = "https://data.etabus.gov.hk/v1/transport/kmb/route/";

    KmbRoute u1 = new RestTemplate().getForObject(url, KmbRoute.class);

    Assertions.assertEquals(u1.getType(), "RouteList");

  }

  @Test
  void testGetApi() throws JsonProcessingException {
    String jsonResponse = "{\"type\":\"1\",\"version\":\"1\",\"generated_timestamp\":\"1\",\"data\":[{\"route\":\"1\",\"bound\":\"1\",\"service_type\":\"1\",\"orig_en\":\"CHUK YUEN ESTATE\",\"orig_tc\":\"竹園邨\",\"orig_sc\":\"竹园邨\",\"dest_en\":\"STAR FERRY\",\"dest_tc\":\"尖沙咀碼頭\",\"dest_sc\":\"尖沙咀码头}]}";

    Data d1 = new Data().builder()
        .route("1")
        .bound("1")
        .service_type("1")
        .orig_en("CHUK YUEN ESTATE")
        .orig_tc("竹園邨")
        .orig_sc("竹园邨")
        .dest_en("STAR FERRY")
        .dest_tc("尖沙咀碼頭")
        .dest_sc("尖沙咀码头")
        .build();

    KmbRoute expectRoute = new KmbRoute().builder()
        .type("1")
        .version("1")
        .generated_timestamp("1")
        .data(new ArrayList<Data>(List.of(d1)))
        .build();

      Mockito.when(rs1.getApi()).thenReturn(expectRoute);

      KmbRoute km1=rs1.getApi();
      ObjectMapper objectMapper=new ObjectMapper();
      
      String actualJson = objectMapper.writeValueAsString(km1);
    assertEquals(jsonResponse, actualJson);

  }

}
