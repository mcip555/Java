package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class TestRequest {

  private Integer billYear;
  private Integer billMonth;
  private Integer billDay;
  private Integer payDay;


}
