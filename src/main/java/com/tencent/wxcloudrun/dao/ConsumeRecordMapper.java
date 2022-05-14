package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ConsumeRecord;

import java.util.List;

public interface ConsumeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumeRecord record);

    int insertSelective(ConsumeRecord record);

    ConsumeRecord selectByPrimaryKey(Integer id);

    List<ConsumeRecord> selectByConsumeId(Integer consumeId);

    int updateByPrimaryKeySelective(ConsumeRecord record);

    int updateByPrimaryKey(ConsumeRecord record);
}