package com.tencent.wxcloudrun.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.wxcloudrun.dao.CardMapper;
import com.tencent.wxcloudrun.model.Card;
import com.tencent.wxcloudrun.service.CardService;
@Service
public class CardServiceImpl implements CardService{

    @Resource
    private CardMapper cardMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Card record) {
        return cardMapper.insert(record);
    }

    @Override
    public int insertSelective(Card record) {
        return cardMapper.insertSelective(record);
    }

    @Override
    public Card selectByPrimaryKey(Integer id) {
        return cardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Card record) {
        return cardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Card record) {
        return cardMapper.updateByPrimaryKey(record);
    }

}
