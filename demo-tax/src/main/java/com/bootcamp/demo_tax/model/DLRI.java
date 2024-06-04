package com.bootcamp.demo_tax.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DLRI {
  @JsonProperty(value = "IRD reference no.\r\n(稅務局參考編號)")
  private String id;
  @JsonProperty(value = "Name (English)\r\n(中文名稱)")
  private String name;
  @JsonProperty(value = "Date of Designation \\r\\n" + //
        "(指明的生效日期)")
  private String dod;
  @JsonProperty(value = "Contact Person Name\r\n(聯絡人姓名)")
  private String contactPersonName;
  @JsonProperty(value = "Contact Address\r\n(聯絡地址)")
  private String contactAddress;
  @JsonProperty(value = "Tel \r\n(電話)")
  private String tel;
  @JsonProperty(value = "Email\r\n(電郵)" )
  private String email;
  
}
