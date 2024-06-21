package com.bootcamp.demo_real.controller.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_real.controller.CommentOperation;
import com.bootcamp.demo_real.entity.mapper.CommentEntityMapper;
import com.bootcamp.demo_real.model.Comment1;
import com.bootcamp.demo_real.model.Questionnair;
import com.bootcamp.demo_real.repository.CommentEntityRepository;
import com.bootcamp.demo_real.service.CommentService;

@Controller
public class CommentController implements CommentOperation {
  @Autowired
  private CommentService commentService;
 

  @Override
  public String cmp(Model model){
  return commentService.cmp(model);
  }
  @Override
  public String savecomment(Comment1 comment,Model model){
    return commentService.savecm(comment,model);
 }
 @Override
 public String qPage(Model model){
  Questionnair questionnaire = new Questionnair();
  questionnaire.setOptions1(Arrays.asList("Option 1A", "Option 1B", "Option 1C"));
  questionnaire.setOptions2(Arrays.asList("Option 2A", "Option 2B", "Option 2C"));
  questionnaire.setOptions3(Arrays.asList("Option 3A", "Option 3B", "Option 3C"));
  model.addAttribute("questionnaire", questionnaire);
  return "Mc.html";

 }
  
}
