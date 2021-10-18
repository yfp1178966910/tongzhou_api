package com.combanc.cas.client.springboot.service;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.WebMessageEntity;
import com.combanc.cas.client.springboot.utils.PageBean;

public interface WebMessageService  extends BaseService<WebMessageEntity>{
    int deleteById(String id);

    void updateAllReadByUserId(String userId);

    int getStates(WebMessageEntity data);

    Result changeStates(WebMessageEntity data);

    PageBean<WebMessageEntity> getMessages(WebMessageEntity data);

    Result changeAllMessages(WebMessageEntity data);
}
