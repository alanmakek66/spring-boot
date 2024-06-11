package com.bootcamp.demo_abph.dto.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_abph.dto.PhotoDto;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;

@Component
public class PhotoDtoMapper {
  public PhotoDto map(PhotoEntity p1){
    return PhotoDto.builder()
    //.albumId(p1.getAlbumId())
    .id(p1.getId())
    .url(p1.getUrl())
    .thumbnailUrl(p1.getThumbnailUrl())
    .title(p1.getTitle())
    .build();
  }
  
}
