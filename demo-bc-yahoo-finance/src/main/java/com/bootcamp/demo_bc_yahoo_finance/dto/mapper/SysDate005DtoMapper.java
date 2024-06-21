package com.bootcamp.demo_bc_yahoo_finance.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate005Dto;

import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate005Entity;


@Component
public class SysDate005DtoMapper {

  public SysDate005Dto map(SysDate005Entity s1){
    return SysDate005Dto.builder()
    .sysDate(s1.getSysDate())
    .build();
  }

  
}
