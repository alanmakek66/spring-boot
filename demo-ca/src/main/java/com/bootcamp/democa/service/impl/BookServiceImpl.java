package com.bootcamp.democa.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bootcamp.democa.controller.BookOperation;
import com.bootcamp.democa.model.Book;
import com.bootcamp.democa.service.BookService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    public final Map<Long, Book> bookMap = new HashMap<>();

    public Map<Long, Book> getBookMap() {
        return this.bookMap;
    }

    @PostConstruct // right after creating bookcontroller bean
    @Async
    public void init() {
        Book b1 = new Book("sam", LocalDate.now());
        Book b2 = new Book("tom", LocalDate.now());
        Book b3 = new Book("jenny", LocalDate.now());
        bookMap.put(b1.getId(), b1);
        bookMap.put(b2.getId(), b2);
        bookMap.put(b3.getId(), b3);
    }


    @Override
    public Book getBook(String author) {
        // login database
        // select , not found ?
        // return new Book(1, "Sally Chan", LocalDate.of(2000, 10, 3));
        if (author == null)
            return null;
        log.info(this.bookMap.entrySet() + " ");
        return this.bookMap.values().stream() //
                .filter(e -> e.getAuthor().equals(author)) //
                .findFirst() // return book object
                .orElse(null);
    }

}