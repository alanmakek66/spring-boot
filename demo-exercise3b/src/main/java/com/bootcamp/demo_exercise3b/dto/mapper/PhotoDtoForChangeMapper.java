package com.bootcamp.demo_exercise3b.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3b.dto.PhotoDtoForChange;
import com.bootcamp.demo_exercise3b.entity.PhotoEntity;

@Component
public class PhotoDtoForChangeMapper {
  public PhotoDtoForChange map(PhotoEntity photoEntity){
    return PhotoDtoForChange.builder()
    .id(photoEntity.getId())
    .title(photoEntity.getTitle())
    .url(photoEntity.getUrl())
    .ablumid(photoEntity.getAlbumEntity().getId().toString())
    .build();

  }
  
}
