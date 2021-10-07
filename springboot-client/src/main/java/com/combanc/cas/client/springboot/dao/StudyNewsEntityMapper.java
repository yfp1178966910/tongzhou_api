package com.combanc.cas.client.springboot.dao;

import com.combanc.cas.client.springboot.entity.StudyNewsEntity;
import com.combanc.cas.client.springboot.entity.StudyNewsEntityExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudyNewsEntityMapper extends BaseDao<StudyNewsEntity> {
    int countByExample(StudyNewsEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(StudyNewsEntity record);

    int insertSelective(StudyNewsEntity record);

    List<StudyNewsEntity> selectByExampleWithBLOBs(StudyNewsEntityExample example);

    List<StudyNewsEntity> selectByExample(StudyNewsEntityExample example);

    StudyNewsEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudyNewsEntity record);

    int updateByPrimaryKeyWithBLOBs(StudyNewsEntity record);

    int updateByPrimaryKey(StudyNewsEntity record);

    int selectByPgExampleCount(StudyNewsEntityExample studyNewsEntityExample);
}