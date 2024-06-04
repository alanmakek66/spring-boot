package com.bootcamp.demo_bus.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_bus.infa.NotFoundException;
import com.bootcamp.demo_bus.model.Data;
import com.bootcamp.demo_bus.model.KmbRoute;
import com.bootcamp.demo_bus.service.RouteService;

@Service
public class RouteServiceImple implements RouteService {

  @Value(value="${api.data-etabus-gov-hk.domain}") //request = true;
private String domain;

@Value(value="${api.data-etabus-gov-hk.endpoints.user}")
private String usersEndpoint;



  @Override 
  public KmbRoute getApi(){

    String url= "https://data.etabus.gov.hk/v1/transport/kmb/route/";

    KmbRoute u1=new RestTemplate().getForObject(url, KmbRoute.class);
    // 1 call api and get json result
    // 2 convert json result to java object

    return u1;

  }

  @Override 
  public List<Data> seachRouteByDest(String dest) throws NotFoundException{
    String url= "https://data.etabus.gov.hk/v1/transport/kmb/route/";

    KmbRoute u1=new RestTemplate().getForObject(url, KmbRoute.class);


    List<Data> datas=
    u1.getData().stream().filter(e->e.getDest_en().toLowerCase().contains(dest.toLowerCase())).collect(Collectors.toList());

    if(datas.size()==0){
      throw new NotFoundException();
    }

    return datas;
  }
  @Override
  public List<Data> seachRouteByDest_tc(String dest) throws NotFoundException{

    String url= "https://data.etabus.gov.hk/v1/transport/kmb/route/";

    KmbRoute u1=new RestTemplate().getForObject(url, KmbRoute.class);


    List<Data> datas=
    u1.getData().stream().filter(e->e.getDest_tc().contains(dest)).collect(Collectors.toList());

    if(datas.size()==0){
      throw new NotFoundException(); 
    }

    return datas;

  }
  @Override
  public List<Data> seachRouteByOrig(String orgi) throws NotFoundException{

    String url= "https://data.etabus.gov.hk/v1/transport/kmb/route/";

    KmbRoute u1=new RestTemplate().getForObject(url, KmbRoute.class);


    List<Data> datas=
    u1.getData().stream().filter(e->e.getOrig_en().toLowerCase().contains(orgi.toLowerCase())).collect(Collectors.toList());

    if(datas.size()==0){
      throw new NotFoundException();
    }

    return datas;

  }

  @Override
  public List<Data> seachRouteByOrig_tc(String orgi) throws NotFoundException{

    String url= "https://data.etabus.gov.hk/v1/transport/kmb/route/";

    KmbRoute u1=new RestTemplate().getForObject(url, KmbRoute.class);


    List<Data> datas=
    u1.getData().stream().filter(e->e.getOrig_tc().toLowerCase().contains(orgi.toLowerCase())).collect(Collectors.toList());

    if(datas.size()==0){
      throw new NotFoundException();
    }

    return datas;


  }

 
  

  


  
}
