package com.bootcamp.democa.controller.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.democa.controller.BookOperation;
import com.bootcamp.democa.model.Book;
import com.bootcamp.democa.service.BookService;
import com.bootcamp.democa.service.impl.BookServiceImpl;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@RestController // =@controller+@responsebody
@Slf4j
public class BookController implements BookOperation {

  @Autowired
  private BookService bs;

  @Override
  public Book getBook(String author) {
    log.info("TEST");
    return new BookServiceImpl().getBook(author);

  }

}
