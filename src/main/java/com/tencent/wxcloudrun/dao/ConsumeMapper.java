package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Consume;

public interface ConsumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consume record);

    int insertSelective(Consume record);

    Consume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consume record);

    int updateByPrimaryKey(Consume record);
}