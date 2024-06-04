package com.bootcamp.demo_bus.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.bootcamp.demo_bus.dto.KmbRouteDto;
import com.bootcamp.demo_bus.model.KmbRoute;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class SaveData1 {
  private KmbRouteDto k1 =new KmbRouteDto();

  public void save(KmbRouteDto kk){
    k1=kk;
  }
  
}
