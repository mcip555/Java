package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Pay;

import java.util.List;

public interface PayService{


    int deleteByPrimaryKey(Integer id);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);

    List<Pay> selectListByBillIdOrderByCreateTimeDescLimit20(Integer billId);



}
