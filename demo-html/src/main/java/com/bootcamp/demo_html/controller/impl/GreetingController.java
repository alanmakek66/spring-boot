package com.bootcamp.demo_html.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_html.controller.GreetingOperation;
import com.bootcamp.demo_html.entity.CommentEntity;
import com.bootcamp.demo_html.entity.mapper.CommentEntityMapper;
import com.bootcamp.demo_html.model.Comment;
import com.bootcamp.demo_html.repository.CommentRepository;
import com.bootcamp.demo_html.service.GreetingService;

@Controller
public class GreetingController implements GreetingOperation{
  @Autowired
  private GreetingService greetingService;
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private CommentEntityMapper commentEntityMapper;

  public String test1(@RequestParam String message, Model model){
    model.addAttribute("greet", message);
    return "greet.html";
  }

  public String test2(@RequestParam String message, Model model){
    return greetingService.greeting(message, model);

  }
  public String comment(Model model){
    model.addAttribute("comment", new Comment());
        return "comment.html";
    }


public String saveComment(Comment comment) {
        
        
        commentRepository.save(commentEntityMapper.map(comment));
        
        return "comment.html";
    }
  
}
