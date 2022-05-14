package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Bill;
import com.tencent.wxcloudrun.model.BillInfo;

public interface BillInfoService {


    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    BillInfo selectByBillId(Integer billId);

    Boolean closeBill(Integer billId);

    Boolean updateBillStatusAndEndTime(Integer billId);
    

}
