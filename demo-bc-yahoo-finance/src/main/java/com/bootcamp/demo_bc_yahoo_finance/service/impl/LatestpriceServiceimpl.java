package com.bootcamp.demo_bc_yahoo_finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;
import com.bootcamp.demo_bc_yahoo_finance.repository.YahooStockEntityRepository;
import com.bootcamp.demo_bc_yahoo_finance.service.LatestpriceService;

@Service
public class LatestpriceServiceimpl implements LatestpriceService {
  @Autowired
  private YahooStockEntityRepository yahooStockEntityRepository;

  @Override
  public List<YahooStockEntity> getALL(){
    return yahooStockEntityRepository.findAll();

  }
  
}
