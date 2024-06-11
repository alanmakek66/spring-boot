package com.bootcamp.demo_exercise3.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Service;


import com.bootcamp.demo_exercise3.dto.CommentidDto;
import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.infa.NotFoundException;
import com.bootcamp.demo_exercise3.repository.CommentRepository;
import com.bootcamp.demo_exercise3.repository.PostRepository;
import com.bootcamp.demo_exercise3.service.CommentService;

@Service
public class CommentServiceimpl implements CommentService {
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  @Lazy
  private CommentService commentService;
  @Autowired
  private PostRepository postRepository;

  @Override
  public List<CommentEntity> getCommentEntity() {
    return commentRepository.findAll();

  }

  @Override
  public List<CommentEntity> getCommentBypostId(String postid) {
    try {
      Long iid = Long.valueOf(postid);
    } catch (NumberFormatException n) {
      throw new NumberFormatException();
    }
    Long iid = Long.valueOf(postid);

    return commentService.getCommentEntity().stream()
        .filter(e -> e.getPostEntity().getId().equals(iid)).collect(Collectors.toList());

  }

  @Override
  public CommentEntity addCommentById(String postid, CommentEntity commentEntity) {
    try {
      Long iid = Long.valueOf(postid);
    } catch (NumberFormatException n) {
      throw new NumberFormatException();
    }
    Long iid = Long.valueOf(postid);

    PostEntity test1 = postRepository.findById(iid)
        .orElseThrow(() -> new RuntimeException());

    if (commentEntity.getPostEntity().getId() != iid) {
      throw new RuntimeException();
    }

    commentRepository.save(commentEntity);
    return commentEntity;

  }
  @Override
  public CommentidDto patchbodybyid(String id ,CommentidDto commentidDto){
    try {
      Long iid = Long.valueOf(id);
    } catch (NumberFormatException n) {
      throw new NumberFormatException();
    }
    Long iid = Long.valueOf(id);

    Optional<CommentEntity> test1 = commentRepository.findById(iid);
    if (test1.isPresent()) {
      CommentEntity c2 = test1.get();
      c2.setBody((commentidDto.getBody()));
      commentRepository.save(c2); // similar to Map put
      return commentidDto;
    }
    throw new NotFoundException();
  }
        

    

  }

