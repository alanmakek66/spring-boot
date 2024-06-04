package com.bootcamp.demo_posts1.service;

import java.util.List;

import com.bootcamp.demo_posts1.dto.RequestDto;
import com.bootcamp.demo_posts1.infa.NotFoundException;
import com.bootcamp.demo_posts1.model.Post;
import com.bootcamp.demo_posts1.postEntity.PostEntity;

public interface PostService {
  List<Post> getPost1();
  List<PostEntity> getallPost();
  PostEntity getPostById(String id) throws NotFoundException;
  List<PostEntity> getPostBybody(String body) throws NotFoundException;
  List<PostEntity> getPostBybodyLike(String body) throws NotFoundException;
  PostEntity replacePostByid(String id,PostEntity post1) throws NotFoundException;
  PostEntity replacePostByid2(String id,RequestDto dto) throws NotFoundException;
  
  
}
