package com.tencent.wxcloudrun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BillInfo {

    private Bill bill;
    private List<Pay> payList;
    private List<Balance> balanceList;
    private Card card;
    private List<BillRecord> billrecordList;


}