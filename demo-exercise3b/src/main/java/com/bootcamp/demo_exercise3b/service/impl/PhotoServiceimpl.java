package com.bootcamp.demo_exercise3b.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_exercise3b.entity.PhotoEntity;
import com.bootcamp.demo_exercise3b.model.Photo;
import com.bootcamp.demo_exercise3b.repository.PhotoRepository;
import com.bootcamp.demo_exercise3b.service.PhotoService;

@Service
public class PhotoServiceimpl implements PhotoService {
  @Autowired
  private PhotoRepository photoRepository;

  @Override
  public List<Photo> getPhoto(){
    String url="https://jsonplaceholder.typicode.com/photos";
    Photo[] photos=new RestTemplate().getForObject(url, Photo[].class);
    
    return Arrays.asList(photos);
    

  }
  @Override
  public List<PhotoEntity> getPhotoEntity(){
    return photoRepository.findAll();

  }
  
}
