package com.tencent.wxcloudrun.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.wxcloudrun.model.Userinfo;
import com.tencent.wxcloudrun.dao.UserinfoMapper;
import com.tencent.wxcloudrun.service.UserinfoService;
@Service
public class UserinfoServiceImpl implements UserinfoService{

    @Resource
    private UserinfoMapper userinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userinfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Userinfo record) {
        return userinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Userinfo record) {
        return userinfoMapper.insertSelective(record);
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Userinfo record) {
        return userinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public Userinfo selectByUserId(String userId) {

        return userinfoMapper.selectByUserId(userId);
    }

}
