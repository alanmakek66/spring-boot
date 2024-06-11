package com.bootcamp.demo_exercise3b.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3b.entity.AlbumEntity;
import com.bootcamp.demo_exercise3b.entity.PhotoEntity;

import com.bootcamp.demo_exercise3b.model.Photo;

@Component
public class PhotoEntityMapper {
  public List<PhotoEntity> map(List<AlbumEntity> albumEntities,List<Photo> photos){
    List<PhotoEntity> list1=new ArrayList<>();
    for(int i=0;i<photos.size();i++){
      for(int k=0;k<albumEntities.size();k++){
        
        if(photos.get(i).getAlbumId().equals(albumEntities.get(k).getId().toString()))
        {
          list1.add(PhotoEntity.builder()
          .id(Long.valueOf(photos.get(i).getId())).title(photos.get(i).getTitle())
          .url(photos.get(i).getUrl()).albumEntity(albumEntities.get(k))
          .build());
}
      }
    } return list1;
  }
  
}
