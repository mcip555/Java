package com.tencent.wxcloudrun.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.wxcloudrun.dao.BillrecordMapper;
import com.tencent.wxcloudrun.model.BillRecord;
import com.tencent.wxcloudrun.service.BillRecordService;

import java.util.List;

@Service
public class BillRecordServiceImpl implements BillRecordService {

    @Resource
    private BillrecordMapper billrecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return billrecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BillRecord record) {
        return billrecordMapper.insert(record);
    }

    @Override
    public int insertSelective(BillRecord record) {
        return billrecordMapper.insertSelective(record);
    }

    @Override
    public BillRecord selectByPrimaryKey(Integer id) {
        return billrecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BillRecord record) {
        return billrecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BillRecord record) {
        return billrecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BillRecord> selectListByBillIdOrderByCreateTimeDesc(Integer billId) {
        return billrecordMapper.selectListByBillIdOrderByCreateTimeDesc(billId);
    }


}
