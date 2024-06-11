package com.bootcamp.demo_exercise3b.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_exercise3b.entity.AlbumEntity;
import com.bootcamp.demo_exercise3b.model.Ablum;
import com.bootcamp.demo_exercise3b.repository.AblumRepository;
import com.bootcamp.demo_exercise3b.service.AblumService;



@Service
public class AblumServiceimpl implements AblumService {

  @Autowired
  private AblumRepository ablumRepository;

@Override
  public List<Ablum>  getAblum(){
    String url="https://jsonplaceholder.typicode.com/albums";
    Ablum[] ablums=new RestTemplate().getForObject(url, Ablum[].class);
    return Arrays.asList(ablums);
  }
  @Override
  public List<AlbumEntity> getAblumentity(){
    return ablumRepository.findAll();

  }

  /* @Override
  public AlbumEntity getAblumByid(String id){
    try{
      Long longid=Long.valueOf(id);
    }catch(NumberFormatException n){
      throw new NumberFormatException();
    }
    Long longid=Long.valueOf(id);
    return ablumRepository.findById(longid).orElseThrow(()->new NumberFormatException());

  } */

  
}
