package com.bootcamp.demo_tax.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_tax.controller.DlriOperation;
import com.bootcamp.demo_tax.dto.DlriDto;
import com.bootcamp.demo_tax.dto.Mapper.MapD;
import com.bootcamp.demo_tax.infa.NotFoundException;
import com.bootcamp.demo_tax.service.DlriService;

@RestController
public class DlriController implements DlriOperation {

  @Autowired
  private DlriService ds1;

  @Autowired
  private MapD md1;

  @Override
  public List<DlriDto> showDlriDto(){
    return ds1.callApi().stream().map(e->md1.map(e)).collect(Collectors.toList());
    
  }

  @Override
  public DlriDto findByid(@RequestParam String id) throws NotFoundException{
    return md1.map(ds1.callApi2(id));

  }
  @Override
  public DlriDto findByemail(@RequestParam String email) throws NotFoundException{
    return md1.map(ds1.callApi3(email));

  }
  
}
