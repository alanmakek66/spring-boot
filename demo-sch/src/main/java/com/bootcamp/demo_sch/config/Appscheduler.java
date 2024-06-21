package com.bootcamp.demo_sch.config;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component


public class Appscheduler  {
  @Scheduled(fixedDelay = 5000)
  @Async
  public void hello()throws InterruptedException{
    Thread.sleep(10000);
System.out.println("hello");
System.out.println("test"+LocalTime.now());
  }
  @Scheduled(fixedRate = 3000)
  @Async
  public void goodbye() throws InterruptedException{
    System.out.println("goodbye");
    Thread.sleep(10000);
    System.out.println("test"+LocalTime.now());
  }
  
}
