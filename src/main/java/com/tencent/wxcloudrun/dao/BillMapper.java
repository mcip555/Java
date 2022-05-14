package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Bill;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    int updateStatusAndEndTimeByPrimaryKey(Bill bill);

    List<Bill> selectListByType1AndDeleted0AndStatusIn10And20OrderByPayDateAsc();
}