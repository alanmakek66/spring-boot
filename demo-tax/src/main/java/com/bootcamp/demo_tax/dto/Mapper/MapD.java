package com.bootcamp.demo_tax.dto.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_tax.dto.DlriDto;
import com.bootcamp.demo_tax.model.DLRI;

@Component
public class MapD {

  public DlriDto map(DLRI d1) {
    DlriDto dd = DlriDto.builder()
        .id(d1.getId())
        .name(d1.getName())
        .tel(d1.getTel())
        .email(d1.getEmail())
        .build();

    return dd;

  }

}
