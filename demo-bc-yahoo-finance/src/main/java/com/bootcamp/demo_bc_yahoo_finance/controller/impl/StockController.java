package com.bootcamp.demo_bc_yahoo_finance.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_bc_yahoo_finance.controller.StockOperation;
import com.bootcamp.demo_bc_yahoo_finance.dto.FiveMin005Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.FiveMin388Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.FiveMin700Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.StocksDto;
import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate005Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate388Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate700Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.YahooStockDto;
import com.bootcamp.demo_bc_yahoo_finance.dto.mapper.FiveMinMapper;
import com.bootcamp.demo_bc_yahoo_finance.dto.mapper.StockDtoMapper;
import com.bootcamp.demo_bc_yahoo_finance.dto.mapper.SysDate005DtoMapper;
import com.bootcamp.demo_bc_yahoo_finance.dto.mapper.SysDate388DtoMapper;
import com.bootcamp.demo_bc_yahoo_finance.dto.mapper.SysDate700DtoMapper;
import com.bootcamp.demo_bc_yahoo_finance.dto.mapper.YahooStockDtoMapper;
import com.bootcamp.demo_bc_yahoo_finance.model.Stock;
import com.bootcamp.demo_bc_yahoo_finance.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController

public class StockController implements StockOperation {

  @Autowired
  private StockService stockService;

  @Autowired
  private StockDtoMapper stockDtoMapper;
  @Autowired
  private YahooStockDtoMapper yahooStockDtoMapper;
  @Autowired
  private SysDate388DtoMapper sysDate388DtoMapper;
  @Autowired
  private SysDate700DtoMapper sysDate700DtoMapper;
  @Autowired
  private SysDate005DtoMapper sysDate005DtoMapper;
  @Autowired
  private FiveMinMapper fiveMinMapper;

  @Override
  public StocksDto getstocks() throws JsonProcessingException {

    return stockDtoMapper.map(stockService.list());

  }

  /*
   * @Override
   * public List<YahooStockDto> getYahooStockDtos() throws
   * JsonProcessingException{
   * return stockService.get5mindate().stream().map(e->yahooStockDtoMapper.map(e))
   * .collect(Collectors.toList());
   * 
   * }
   */
  @Override
  public void updateStock() throws JsonProcessingException {
    stockService.update5mindata();
  }

  @Override
  public List<YahooStockDto> getYahooStockDtosT(String symbol, String type) throws JsonProcessingException {
    return stockService.get5mindate(symbol, type).stream()
        .map(e -> yahooStockDtoMapper.map(e)).collect(Collectors.toList());

  }

  @Override
  public SysDate388Dto getSysDate388() throws JsonProcessingException {
    String symbol="0388.HK";
    return sysDate388DtoMapper.map(stockService.getSysDate388(symbol));

  }

  @Override
  public SysDate700Dto getSysDate700() throws JsonProcessingException {
    String symbol="0700.HK";
    return sysDate700DtoMapper.map(stockService.getSysDate700(symbol));
  }

  @Override
  public SysDate005Dto getSysDate005() throws JsonProcessingException {
    String symbol="0005.HK";
    return sysDate005DtoMapper.map(stockService.getSysDate005(symbol));
  }

  @Override
  public FiveMin388Dto get0388Data()
      throws JsonProcessingException {
    return new FiveMin388Dto(fiveMinMapper.map(stockService.getDataforRedis388()));

  }
  @Override
  public FiveMin700Dto get0700Data()
      throws JsonProcessingException {
    return new FiveMin700Dto(fiveMinMapper.map(stockService.getDataforRedis700()));

  }
  @Override
  public FiveMin005Dto get0005Data()
      throws JsonProcessingException {
    return new FiveMin005Dto(fiveMinMapper.map(stockService.getDataforRedis005()));

  }

}
