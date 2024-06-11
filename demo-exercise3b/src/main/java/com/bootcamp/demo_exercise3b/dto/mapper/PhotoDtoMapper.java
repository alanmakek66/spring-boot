package com.bootcamp.demo_exercise3b.dto.mapper;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3b.dto.PhotoDto;
import com.bootcamp.demo_exercise3b.dto.PhotoDtoForChange;

@Component
public class PhotoDtoMapper {
  public PhotoDto map(PhotoDtoForChange photoDtoForChange){
    return PhotoDto.builder()
    .id(photoDtoForChange.getId())
    .url(photoDtoForChange.getUrl())
    .title(photoDtoForChange.getTitle())
    .build();
  }
  
}
