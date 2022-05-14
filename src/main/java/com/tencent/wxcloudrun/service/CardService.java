package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Card;
public interface CardService{


    int deleteByPrimaryKey(Integer id);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

}
