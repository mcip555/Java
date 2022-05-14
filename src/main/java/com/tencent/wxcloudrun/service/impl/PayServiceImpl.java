package com.tencent.wxcloudrun.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.wxcloudrun.dao.PayMapper;
import com.tencent.wxcloudrun.model.Pay;
import com.tencent.wxcloudrun.service.PayService;

import java.util.List;

@Service
public class PayServiceImpl implements PayService{

    @Resource
    private PayMapper payMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Pay record) {
        return payMapper.insert(record);
    }

    @Override
    public int insertSelective(Pay record) {
        return payMapper.insertSelective(record);
    }

    @Override
    public Pay selectByPrimaryKey(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Pay record) {
        return payMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pay record) {
        return payMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Pay> selectListByBillIdOrderByCreateTimeDescLimit20(Integer billId) {
        return payMapper.selectListByBillIdOrderByCreateTimeDescLimit20(billId);
    }


}
