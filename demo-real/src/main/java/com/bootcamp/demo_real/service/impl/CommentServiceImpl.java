package com.bootcamp.demo_real.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bootcamp.demo_real.entity.mapper.CommentEntityMapper;
import com.bootcamp.demo_real.model.Comment1;
import com.bootcamp.demo_real.repository.CommentEntityRepository;
import com.bootcamp.demo_real.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService {

   @Autowired
  private CommentEntityRepository commentEntityRepository; 
  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Override
  public String cmp(Model model){
    model.addAttribute("comment", new Comment1());
    return "CommentPage.html";

  }


  @Override
  public String savecm(Comment1 c1,Model model){
    model.addAttribute("comment", new Comment1());
    
    commentEntityRepository.save(commentEntityMapper.map(c1));

    return "CommentPage.html";


  }
  
}
