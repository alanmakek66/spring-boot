package com.bootcamp.demo_exercise3.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_exercise3.controller.CommentOperation;
import com.bootcamp.demo_exercise3.dto.CommentDto;
import com.bootcamp.demo_exercise3.dto.CommentidDto;
import com.bootcamp.demo_exercise3.dto.mapper.CommentDtoMapper;
import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.infa.ApiResp;
import com.bootcamp.demo_exercise3.service.CommentService;

@RestController
public class CommentController implements CommentOperation {
  @Autowired
  private CommentService commentService;
  @Autowired
  private CommentDtoMapper commentDtoMapper;

  @Override
  public ApiResp<CommentDto> getallComment() {
    return ApiResp.<CommentDto> builder()
    .id("000000")
    .message("SUCCESS")
    .data(commentService.getCommentEntity().stream().map(e -> commentDtoMapper.map(e))
    .collect(Collectors.toList()))
    .build();

    
 /*    
    commentService.getCommentEntity().stream().map(e -> commentDtoMapper.map(e))
        .collect(Collectors.toList()); */

  }

  @Override
  public ApiResp<CommentDto> getCommentBypostId(String postid) {
    return 
    ApiResp.<CommentDto> builder()
    .id("000000")
    .message("SUCCESS")
    .data(commentService.getCommentBypostId(postid).stream().map(e -> commentDtoMapper.map(e))
    .collect(Collectors.toList()))
    .build();
    
 /*    
    commentService.getCommentBypostId(postid).stream().map(e -> commentDtoMapper.map(e))
        .collect(Collectors.toList()); */
  }

  @Override
  public ApiResp<CommentEntity> addCommentById(@RequestParam String postid, @RequestBody CommentEntity commentEntity) {
    return ApiResp.<CommentEntity>builder()
    .id("000000")
    .message("success")
    .data(List.of(commentService.addCommentById(postid, commentEntity)))
    .build();
    
    //commentService.addCommentById(postid, commentEntity);
  }

  @Override
  public ApiResp<CommentidDto> patchbodybyid(String id, CommentidDto commentidDto) {
    return ApiResp.<CommentidDto>builder()
        .id("000000")
        
        //.data(List.of(commentService.patchbodybyid(id, commentidDto)))
      
        .build();

    // commentService.patchbodybyid(id, commentidDto);

  }

}
