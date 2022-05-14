package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Balance;

import java.util.List;

public interface BalanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Balance record);

    int insertSelective(Balance record);

    Balance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Balance record);

    int updateByPrimaryKey(Balance record);

    List<Balance> selectListByCardId(Integer cardId);

    List<Balance> selectListByCardIdOrderByCreateTimeDescLimit20(Integer cardId);


    Balance selectListByCardIdAndDeleted0AndChangeBalanceLt0OrderByCreateTimeDescLimit1(Integer cardId);


}