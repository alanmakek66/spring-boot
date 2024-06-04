package com.bootcamp.demo_tax.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_tax.dto.DlriDto;
import com.bootcamp.demo_tax.infa.NotFoundException;

public interface DlriOperation {

  @GetMapping(value = "/test")
  List<DlriDto> showDlriDto();

  @GetMapping(value = "/find")
  DlriDto findByid(@RequestParam String id) throws NotFoundException;

  @GetMapping(value = "/find2")
  DlriDto findByemail(@RequestParam String email) throws NotFoundException;


  
}
