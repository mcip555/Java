package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.BillInfo;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.wxcloudrun.dao.BalanceMapper;
import com.tencent.wxcloudrun.model.Balance;
import com.tencent.wxcloudrun.service.BalanceService;

import java.util.List;


@Service
public class BalanceServiceImpl implements BalanceService {



    @Resource
    private BalanceMapper balanceMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return balanceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Balance record) {
        return balanceMapper.insert(record);
    }

    @Override
    public int insertSelective(Balance record) {
        return balanceMapper.insertSelective(record);
    }

    @Override
    public Balance selectByPrimaryKey(Integer id) {
        return balanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Balance record) {
        return balanceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Balance record) {
        return balanceMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Balance> selectListByCardId(Integer cardId) {
        return balanceMapper.selectListByCardId(cardId);
    }

    @Override
    public List<Balance> selectListByCardIdOrderByCreateTimeDescLimit20(Integer cardId) {
        return balanceMapper.selectListByCardIdOrderByCreateTimeDescLimit20(cardId);
    }

    @Override
    public Balance selectListByCardIdAndDeleted0AndChangeBalanceLt0OrderByCreateTimeDescLimit1(Integer cardId) {
        return balanceMapper.selectListByCardIdAndDeleted0AndChangeBalanceLt0OrderByCreateTimeDescLimit1(cardId);
    }


}
