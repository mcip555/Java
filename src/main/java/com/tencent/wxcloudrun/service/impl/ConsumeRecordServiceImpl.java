package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.Card;
import com.tencent.wxcloudrun.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.tencent.wxcloudrun.model.ConsumeRecord;
import com.tencent.wxcloudrun.dao.ConsumeRecordMapper;
import com.tencent.wxcloudrun.service.ConsumeRecordService;

import java.util.List;

@Service
public class ConsumeRecordServiceImpl implements ConsumeRecordService{

    @Autowired
    private CardService cardService;

    @Resource
    private ConsumeRecordMapper consumeRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return consumeRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ConsumeRecord record) {
        return consumeRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(ConsumeRecord record) {
        return consumeRecordMapper.insertSelective(record);
    }

    @Override
    public ConsumeRecord selectByPrimaryKey(Integer id) {
        return consumeRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ConsumeRecord record) {
        return consumeRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ConsumeRecord record) {
        return consumeRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ConsumeRecord> selectByConsumeId(Integer consumeId) {
        List<ConsumeRecord> consumeRecordList = consumeRecordMapper.selectByConsumeId(consumeId);
        for(ConsumeRecord consumeRecord:consumeRecordList){
            Card card = cardService.selectByPrimaryKey(consumeRecord.getCardId());
            if(null == card){
                continue;
            }
            consumeRecord.setBankName(card.getBankName());
            consumeRecord.setCardNo(card.getCardNo());
            consumeRecord.setUserName(card.getUserName());
        }
        return consumeRecordList;
    }

}
