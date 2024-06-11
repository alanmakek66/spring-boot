package com.bootcamp.demo_exercise3b.entity.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3b.entity.AlbumEntity;
import com.bootcamp.demo_exercise3b.model.Ablum;

@Component
public class AblumEntityMapper {
  public AlbumEntity mapAlbumEntity(Ablum ablum){
    return AlbumEntity.builder()
    .id(Long.valueOf(ablum.getId()))
    .title(ablum.getTitle())
    .userId(ablum.getUserId())
    .build();
    
  }
  
}
