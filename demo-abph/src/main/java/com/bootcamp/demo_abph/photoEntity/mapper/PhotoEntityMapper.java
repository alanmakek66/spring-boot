package com.bootcamp.demo_abph.photoEntity.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_abph.dto.PhotoDto;
import com.bootcamp.demo_abph.model.Photo;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;

@Component
public class PhotoEntityMapper {
  public PhotoEntity map(Photo p1){
    return PhotoEntity.builder()
    .albumId(p1.getAlbumId())
    .id(p1.getId())
    .url(p1.getUrl())
    .thumbnailUrl(p1.getThumbnailUrl())
    .title(p1.getTitle())
    .build();
  }
  
}
