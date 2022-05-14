package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Userinfo;
public interface UserinfoService{


    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    Userinfo selectByUserId(String userId);

}
