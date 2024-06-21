package com.bootcamp.demo_real.service;

import org.springframework.ui.Model;

import com.bootcamp.demo_real.model.Comment1;

public interface CommentService {
  String cmp(Model model);
  String savecm(Comment1 c1,Model model );
  
}
