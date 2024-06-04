package com.bootcamp.demo_bus.service;

import java.util.List;

import com.bootcamp.demo_bus.infa.NotFoundException;
import com.bootcamp.demo_bus.model.Data;
import com.bootcamp.demo_bus.model.KmbRoute;



public interface RouteService {

  KmbRoute getApi();

 List<Data> seachRouteByDest(String dest) throws NotFoundException;
 List<Data> seachRouteByDest_tc(String dest) throws NotFoundException;
 List<Data> seachRouteByOrig(String orgi) throws NotFoundException;
 List<Data> seachRouteByOrig_tc(String orgi) throws NotFoundException;



  
}
