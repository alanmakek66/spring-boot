package com.bootcamp.demo_bc_yahoo_finance.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate388Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate700Dto;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate388Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate700Entity;

@Component
public class SysDate700DtoMapper {
  public SysDate700Dto map(SysDate700Entity s1){
    return SysDate700Dto.builder()
    .sysDate(s1.getSysDate())
    .build();
  }
  
}
