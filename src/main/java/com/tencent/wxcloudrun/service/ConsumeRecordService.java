package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ConsumeRecord;

import java.util.List;

public interface ConsumeRecordService{


    int deleteByPrimaryKey(Integer id);

    int insert(ConsumeRecord record);

    int insertSelective(ConsumeRecord record);

    ConsumeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumeRecord record);

    int updateByPrimaryKey(ConsumeRecord record);

    List<ConsumeRecord> selectByConsumeId(Integer consumeId);

}
