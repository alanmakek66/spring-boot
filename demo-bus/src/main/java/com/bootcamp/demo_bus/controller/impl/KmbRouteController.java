package com.bootcamp.demo_bus.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_bus.config.SaveData1;
import com.bootcamp.demo_bus.controller.KmbRouteOperation;
import com.bootcamp.demo_bus.dto.DataDto;
import com.bootcamp.demo_bus.dto.KmbRouteDto;
import com.bootcamp.demo_bus.dto.MapperForKmbR.MapData;
import com.bootcamp.demo_bus.dto.MapperForKmbR.MapKmbRoute;
import com.bootcamp.demo_bus.infa.NotFoundException;
import com.bootcamp.demo_bus.service.RouteService;

@RestController
public class KmbRouteController implements KmbRouteOperation {

  @Autowired 
  private RouteService rs1;

  @Autowired
  private SaveData1 sd1;

  @Autowired
  private MapKmbRoute mr1;

  @Autowired
  private MapData md1;

  @Override
   public KmbRouteDto getapi(){

    //mr1.map( rs1.getApi());
    sd1.save(mr1.map( rs1.getApi()));
    

    return mr1.map( rs1.getApi());
   }

   @Override
   public KmbRouteDto getapipost(){
    return sd1.getK1();
   }

   @Override 
   public List<DataDto> getRouteByDest(@RequestParam String dest) throws NotFoundException{

    return rs1.seachRouteByDest(dest).stream().map(e->md1.map(e)).collect(Collectors.toList());


   }

   @Override 
   public List<DataDto> getRouteByDest_tc(@RequestParam String dest) throws NotFoundException{
    return rs1.seachRouteByDest_tc(dest).stream().map(e->md1.map(e)).collect(Collectors.toList());
   }

   @Override
   public List<DataDto> getRouteByOrgi(@RequestParam String orgi) throws NotFoundException{
    return rs1.seachRouteByOrig(orgi).stream().map(e->md1.map(e)).collect(Collectors.toList());
   }
   @Override
   public List<DataDto> getRouteByOrgi_tc(@RequestParam String orgi) throws NotFoundException{
    return rs1.seachRouteByOrig_tc(orgi).stream().map(e->md1.map(e)).collect(Collectors.toList());

   }
  
}
