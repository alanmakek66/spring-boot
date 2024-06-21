package com.bootcamp.demo_real.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.demo_real.model.Comment1;

public interface CommentOperation {
  @GetMapping(value = "/commentpage")
  String cmp(Model model);

  @PostMapping(value = "/save")
  String savecomment(Comment1 c1,Model model);

  @GetMapping(value = "/q/page")
  String qPage(Model model);
  
}
