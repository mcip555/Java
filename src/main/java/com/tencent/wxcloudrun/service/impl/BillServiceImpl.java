package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.BillInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.wxcloudrun.dao.BillMapper;
import com.tencent.wxcloudrun.model.Bill;
import com.tencent.wxcloudrun.service.BillService;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Resource
    private BillMapper billMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return billMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Bill record) {
        return billMapper.insert(record);
    }

    @Override
    public int insertSelective(Bill record) {
        return billMapper.insertSelective(record);
    }

    @Override
    public Bill selectByPrimaryKey(Integer id) {
        return billMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Bill record) {
        return billMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Bill record) {
        return billMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateStatusAndEndTimeByPrimaryKey(Bill bill) {

        return billMapper.updateStatusAndEndTimeByPrimaryKey(bill);
    }

    @Override
    public List<Bill> selectListByType1AndDeleted0AndStatusIn10And20OrderByPayDateAsc() {
        return billMapper.selectListByType1AndDeleted0AndStatusIn10And20OrderByPayDateAsc();
    }


}
