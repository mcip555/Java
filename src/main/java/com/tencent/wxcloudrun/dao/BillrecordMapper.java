package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.BillRecord;

import java.util.List;

public interface BillrecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillRecord record);

    int insertSelective(BillRecord record);

    BillRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillRecord record);

    int updateByPrimaryKey(BillRecord record);

    List<BillRecord> selectListByBillIdOrderByCreateTimeDesc(Integer billId);
        }