package com.bootcamp.demo_exercise3.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_exercise3.dto.CommentDto;
import com.bootcamp.demo_exercise3.dto.CommentidDto;
import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;



public interface CommentService {

  List<CommentEntity> getCommentEntity();
  List<CommentEntity> getCommentBypostId( String postid);
  CommentEntity addCommentById(String id, CommentEntity commentEntity );
  CommentidDto patchbodybyid(String id ,CommentidDto commentidDto);
  
  
}
