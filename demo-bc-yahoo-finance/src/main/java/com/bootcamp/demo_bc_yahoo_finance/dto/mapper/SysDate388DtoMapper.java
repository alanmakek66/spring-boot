package com.bootcamp.demo_bc_yahoo_finance.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate388Dto;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate388Entity;

@Component
public class SysDate388DtoMapper {
  public SysDate388Dto map(SysDate388Entity s1){
    return SysDate388Dto.builder()
    .sysDate(s1.getSysDate())
    .build();
  }
  
}
