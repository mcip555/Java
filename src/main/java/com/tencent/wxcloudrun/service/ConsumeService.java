package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.model.Bill;
import com.tencent.wxcloudrun.model.Consume;

import java.util.List;

public interface ConsumeService {

    List<Bill> showConsumeListPage();


    int deleteByPrimaryKey(Integer id);

    int insert(Consume record);

    int insertSelective(Consume record);

    Consume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consume record);

    int updateByPrimaryKey(Consume record);



}

