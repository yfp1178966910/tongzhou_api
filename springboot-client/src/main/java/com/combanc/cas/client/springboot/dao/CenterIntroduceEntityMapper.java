package com.combanc.cas.client.springboot.dao;

import com.combanc.cas.client.springboot.entity.CenterIntroduceEntity;
import com.combanc.cas.client.springboot.entity.CenterIntroduceEntityExample;
import java.util.List;

public interface CenterIntroduceEntityMapper {
    int countByExample(CenterIntroduceEntityExample example);

    int deleteByPrimaryKey(String id);


    int insert(CenterIntroduceEntity record);

    int insertSelective(CenterIntroduceEntity record);

    List<CenterIntroduceEntity> selectByExampleWithBLOBs(CenterIntroduceEntityExample example);

    List<CenterIntroduceEntity> selectByExample(CenterIntroduceEntityExample example);

    CenterIntroduceEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CenterIntroduceEntity record);

    int updateByPrimaryKeyWithBLOBs(CenterIntroduceEntity record);

    int updateByPrimaryKey(CenterIntroduceEntity record);

    int selectByPgExampleCount(CenterIntroduceEntityExample example);
}