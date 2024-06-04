package com.bootcamp.democa.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
  private static AtomicLong count = new AtomicLong(0);

  private long id;
  private String author;
  private LocalDate localDate;

  public Book(String author, LocalDate localDate) {
    this.id=count.incrementAndGet();
    this.author = author;
    this.localDate = localDate;

  }

}