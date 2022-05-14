package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Bill;
import com.tencent.wxcloudrun.model.BillInfo;

import java.util.List;

public interface BillService{


    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    int updateStatusAndEndTimeByPrimaryKey(Bill bill);


    List<Bill> selectListByType1AndDeleted0AndStatusIn10And20OrderByPayDateAsc();


}
