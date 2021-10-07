package com.combanc.cas.client.springboot.dao;

import com.combanc.cas.client.springboot.entity.WebMessageEntity;
import com.combanc.cas.client.springboot.entity.WebMessageEntityExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WebMessageEntityMapper extends BaseDao<WebMessageEntity> {
    int deleteByPrimaryKey(String id);

    int insert(WebMessageEntity record);

    int insertSelective(WebMessageEntity record);

    List<WebMessageEntity> selectByExample(WebMessageEntityExample example);

    WebMessageEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WebMessageEntity record);

    int updateByPrimaryKey(WebMessageEntity record);

    List<WebMessageEntity> selectByPgExample(WebMessageEntityExample webMessageEntityExample);

    int selectByPgExampleCount(WebMessageEntityExample dto);

    int getStates(WebMessageEntity data);

    List<WebMessageEntity> getMessages(WebMessageEntity data);

    int getMessagesCount(WebMessageEntity dto);

    int changeAllMessages(WebMessageEntity data);
}