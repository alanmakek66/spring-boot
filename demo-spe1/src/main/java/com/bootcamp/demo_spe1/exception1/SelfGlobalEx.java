package com.bootcamp.demo_spe1.exception1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootcamp.demo_spe1.infra.GlobalExceptionHandling;

@RestControllerAdvice
public class SelfGlobalEx extends GlobalExceptionHandling {
  
}
