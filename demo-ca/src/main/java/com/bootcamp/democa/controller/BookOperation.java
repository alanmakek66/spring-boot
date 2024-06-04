package com.bootcamp.democa.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.democa.model.Book;

public interface BookOperation {
  

  @GetMapping(value = "/books")
  Book getBook(@RequestParam String author);

  

 
  
}
