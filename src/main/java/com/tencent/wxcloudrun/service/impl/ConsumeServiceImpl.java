package com.tencent.wxcloudrun.service.impl;


import com.tencent.wxcloudrun.dao.ConsumeMapper;
import com.tencent.wxcloudrun.model.Balance;
import com.tencent.wxcloudrun.model.Bill;
import com.tencent.wxcloudrun.model.Card;
import com.tencent.wxcloudrun.model.Consume;
import com.tencent.wxcloudrun.service.BalanceService;
import com.tencent.wxcloudrun.service.BillService;
import com.tencent.wxcloudrun.service.CardService;
import com.tencent.wxcloudrun.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Resource
    ConsumeMapper consumeMapper;

    @Autowired
    protected BillService billService;

    @Autowired
    protected BalanceService balanceService;

    @Autowired
    protected CardService cardService;

    @Override
    public List<Bill> showConsumeListPage() {

        List<Bill> billList = billService.selectListByType1AndDeleted0AndStatusIn10And20OrderByPayDateAsc();

        for (Bill bill : billList) {
            Balance balance = balanceService.selectListByCardIdAndDeleted0AndChangeBalanceLt0OrderByCreateTimeDescLimit1(bill.getCardId());
            if (null != balance) {
                bill.setLastConsume(balance.getChangeBalance());
            }
            Card card = cardService.selectByPrimaryKey(bill.getCardId());
            if (null != card) {
                bill.setBalance(card.getBalance());
            }

        }

        return billList;
    }




    @Override
    public int deleteByPrimaryKey(Integer id) {
        return consumeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Consume record) {
        return consumeMapper.insert(record);
    }

    @Override
    public int insertSelective(Consume record) {
        return consumeMapper.insertSelective(record);
    }

    @Override
    public Consume selectByPrimaryKey(Integer id) {
        return consumeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Consume record) {
        return consumeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Consume record) {
        return consumeMapper.updateByPrimaryKey(record);
    }


}

