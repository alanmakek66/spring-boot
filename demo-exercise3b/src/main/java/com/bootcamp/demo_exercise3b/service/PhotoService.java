package com.bootcamp.demo_exercise3b.service;

import java.util.List;

import com.bootcamp.demo_exercise3b.entity.PhotoEntity;

import com.bootcamp.demo_exercise3b.model.Photo;

public interface PhotoService {
  List<Photo> getPhoto();
  List<PhotoEntity> getPhotoEntity();
 
  
}
