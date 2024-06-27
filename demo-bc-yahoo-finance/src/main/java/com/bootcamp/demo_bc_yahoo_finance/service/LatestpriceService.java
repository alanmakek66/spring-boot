package com.bootcamp.demo_bc_yahoo_finance.service;

import java.util.List;

import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;

public interface LatestpriceService {
  List<YahooStockEntity> getALL();
  
}
