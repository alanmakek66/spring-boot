package com.bootcamp.democa.service;



import java.util.Map;

import org.springframework.stereotype.Service;

import com.bootcamp.democa.model.Book;



public interface BookService {
  
  Book getBook(String author);


  Map<Long, Book> getBookMap();

  

  
}
