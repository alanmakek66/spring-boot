package com.bootcamp.demo_abph.ablumAndphotoEntityMapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_abph.ablumAndphotoEntityMapper.AblumandPhotoEntity;
import com.bootcamp.demo_abph.ablumEntity.AblumEntity;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;

@Component
public class AblumandPhotoEntityMapper {
  public List<AblumandPhotoEntity> map(List<AblumEntity> ablumEntities
  ,List<PhotoEntity> photoEntities){
    return ablumEntities.stream().map(ablum->{
      List<PhotoEntity> test1 =photoEntities.stream()
      .filter(e->e.getAlbumId().equals(ablum.getId())).collect(Collectors.toList());
      
      return  AblumandPhotoEntity.builder()
      .id(ablum.getId())
      .userId(ablum.getUserId())
      .title(ablum.getTitle())
      .photoEntities(test1)
      .build();
    }).collect(Collectors.toList());
  }
  
}
