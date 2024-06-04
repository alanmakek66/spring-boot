package com.bootcamp.demo_posts1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_posts1.dto.RequestDto;
import com.bootcamp.demo_posts1.infa.NotFoundException;
import com.bootcamp.demo_posts1.model.Post;
import com.bootcamp.demo_posts1.postEntity.PostEntity;

public interface PostOperation {

  @GetMapping(value = "/post1")
  List<Post> getpost();

  @GetMapping(value = "/database/post")
  List<PostEntity> getpostDB();

  @GetMapping(value = "/database/post/id")
  PostEntity getPostByid(@RequestParam String id);

  @GetMapping(value = "/database/post/body/contain")
  List<PostEntity> getPostBybodyContain(@RequestParam String body) throws NotFoundException;

  @GetMapping(value = "/database/post/body/like")
  List<PostEntity> getPostBybodyLike(@RequestParam String body) throws NotFoundException;

  @PutMapping(value = "/database/post/id")
  PostEntity replacePostbyid(@RequestParam String id,@RequestBody PostEntity post1) throws NotFoundException;

  @PatchMapping(value = "/database/post/id")
  PostEntity updateBodyById(@RequestParam String id,@RequestBody RequestDto dto) throws
  NotFoundException;

  
}
