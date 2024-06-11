package com.bootcamp.demo_exercise3b.service;

import java.util.List;

import com.bootcamp.demo_exercise3b.entity.AlbumEntity;
import com.bootcamp.demo_exercise3b.model.Ablum;

public interface AblumService {
  List<Ablum> getAblum();
  List<AlbumEntity> getAblumentity();
  //AlbumEntity getAblumByid(String id);
  
}
