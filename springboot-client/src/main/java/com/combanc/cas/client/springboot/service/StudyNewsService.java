package com.combanc.cas.client.springboot.service;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.StudyNewsEntity;

public interface StudyNewsService extends BaseService<StudyNewsEntity> {
    Result read(StudyNewsEntity data);
}
