package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Pay;

import java.util.List;

public interface PayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);

    List<Pay> selectListByBillIdOrderByCreateTimeDescLimit20(Integer billId);
}