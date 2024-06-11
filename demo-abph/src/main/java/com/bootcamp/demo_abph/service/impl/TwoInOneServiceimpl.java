package com.bootcamp.demo_abph.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_abph.ablumAndphotoEntityMapper.AblumandPhotoEntity;
import com.bootcamp.demo_abph.ablumAndphotoEntityMapper.Mapper.AblumandPhotoEntityMapper;
import com.bootcamp.demo_abph.ablumEntity.AblumEntity;
import com.bootcamp.demo_abph.ablumEntity.mapper.AblumEntityMapper;
import com.bootcamp.demo_abph.model.Ablum;
import com.bootcamp.demo_abph.model.Photo;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;
import com.bootcamp.demo_abph.photoEntity.mapper.PhotoEntityMapper;
import com.bootcamp.demo_abph.repository.AblumRepository;
import com.bootcamp.demo_abph.repository.PhotoRepository;
import com.bootcamp.demo_abph.service.TwoInOneService;

@Service
public class TwoInOneServiceimpl implements TwoInOneService {

  @Autowired
  private AblumRepository ablumRepository;
  @Autowired
  private PhotoRepository photoRepository;

  @Autowired
  private AblumEntityMapper ablumEntityMapper;
  @Autowired
  private PhotoEntityMapper photoEntityMapper;
  @Autowired
  private AblumandPhotoEntityMapper ablumandPhotoEntityMapper;

  @Autowired
  @Lazy
  private TwoInOneService twoInOneService;

  @Override
  public List<AblumEntity> pushAblumtoDB() {
    String url = "https://jsonplaceholder.typicode.com/albums";
    Ablum[] ablums = new RestTemplate().getForObject(url, Ablum[].class);

    List<AblumEntity> ablumEntities = Arrays.asList(ablums).stream()
        .map(e -> ablumEntityMapper.map(e)).collect(Collectors.toList());

    ablumRepository.saveAll(ablumEntities);

    return ablumRepository.findAll();
  }

  @Override
  public List<PhotoEntity> pushPhototoDB() {
    String url = "https://jsonplaceholder.typicode.com/photos";
    Photo[] photos = new RestTemplate().getForObject(url, Photo[].class);

    List<PhotoEntity> photoEntities = Arrays.asList(photos).stream()
        .map(e -> photoEntityMapper.map(e)).collect(Collectors.toList());

    photoRepository.saveAll(photoEntities);

    return photoRepository.findAll();
  }

  @Override
  public List<AblumEntity> getAblumtoDB() {
    return ablumRepository.findAll();
  }

  @Override
  public List<PhotoEntity> getPhototoDB() {
    return photoRepository.findAll();
  }

  @Override
  public List<AblumandPhotoEntity> getAblumandPhotoEntities() {
    List<AblumEntity> lista=twoInOneService.getAblumtoDB();
    List<PhotoEntity> listp =twoInOneService.getPhototoDB();

    return ablumandPhotoEntityMapper.map(lista,listp);

  }
  @Override 
   public List<AblumEntity> findByUserId(@Param("userId")String userid){
    return ablumRepository.findByUserId(userid)
    .orElseThrow(()-> new RuntimeException());
  }
  @Override
  public List<PhotoEntity> findBytitle(@Param("str") String str){
    return photoRepository.findBytitle(str).orElseThrow(()->new RuntimeException());
  }

}
