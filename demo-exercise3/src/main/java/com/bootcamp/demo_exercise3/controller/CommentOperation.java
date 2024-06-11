package com.bootcamp.demo_exercise3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.bootcamp.demo_exercise3.dto.CommentDto;
import com.bootcamp.demo_exercise3.dto.CommentidDto;
import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.infa.ApiResp;

public interface CommentOperation {

@GetMapping(value = "/all/comment")
ApiResp<CommentDto> getallComment();

  @GetMapping(value = "/by/postid/comment")
  ApiResp<CommentDto> getCommentBypostId(@RequestParam String postid);

  // List<CommentDto> getCommentBypostId(@RequestParam String postid);
  @PostMapping(value = "add/comment/postid")
  ApiResp<CommentEntity> addCommentById(@RequestParam String postid
  ,@RequestBody CommentEntity commentEntity );

  @PatchMapping(value = "patch/body/bycommentid")
  ApiResp<CommentidDto> patchbodybyid(@RequestParam String id,
  @RequestBody CommentidDto commentidDto );


  
}
