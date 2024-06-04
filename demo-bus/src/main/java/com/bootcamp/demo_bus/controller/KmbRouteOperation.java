package com.bootcamp.demo_bus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_bus.dto.DataDto;
import com.bootcamp.demo_bus.dto.KmbRouteDto;
import com.bootcamp.demo_bus.infa.NotFoundException;

public interface KmbRouteOperation {

  @GetMapping(value = "/kmb/route")
  KmbRouteDto getapi();

  @GetMapping(value = "/kmb/route/post")
  KmbRouteDto getapipost();

  @GetMapping(value = "/kmb/dest")
  List<DataDto> getRouteByDest(@RequestParam String dest) throws NotFoundException;

  @GetMapping(value = "/kmb/dest/tc")
  List<DataDto> getRouteByDest_tc(@RequestParam String dest) throws NotFoundException;

  @GetMapping(value = "/kmb/orgi")
  List<DataDto> getRouteByOrgi(@RequestParam String orgi) throws NotFoundException;

  @GetMapping(value = "/kmb/orgi/tc")
  List<DataDto> getRouteByOrgi_tc(@RequestParam String orgi) throws NotFoundException;

  

  
}
