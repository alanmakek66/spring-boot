package com.bootcamp.demo_bc_yahoo_finance.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_bc_yahoo_finance.controller.LatestpriceOperation;
import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice005dto;
import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice388dto;
import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice700dto;
import com.bootcamp.demo_bc_yahoo_finance.dto2.mapper.LatestpriceMapper;
import com.bootcamp.demo_bc_yahoo_finance.service.LatestpriceService;


@RestController
public class LatestpriceController implements LatestpriceOperation {

  @Autowired
  private LatestpriceService latestpriceService;

  @Autowired
  private LatestpriceMapper latestpriceMapper;

  @Override
  public Latestprice005dto latest005(){
    return latestpriceMapper.map(latestpriceService.getALL());

    
}
@Override
public Latestprice700dto latest700(){
  return latestpriceMapper.map2(latestpriceService.getALL());
}

@Override
public Latestprice388dto latest388(){
  return latestpriceMapper.map3(latestpriceService.getALL());
}
  
}
