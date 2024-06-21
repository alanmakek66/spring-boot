package com.bootcamp.demo_html.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_html.model.Comment;

public interface GreetingOperation {
  @GetMapping(value = "/test1")
  String test1(@RequestParam String message, Model model);

  @GetMapping(value = "/test2")
  String test2(@RequestParam String message, Model model);


  @GetMapping(value = "/comment")
  String comment(Model model);

  @PostMapping("/save")
   String saveComment( Comment comment);
  
}
