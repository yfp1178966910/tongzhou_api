package com.combanc.cas.client.springboot.service;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.SignInEntity;
import com.combanc.cas.client.springboot.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface SignInService extends BaseService<SignInEntity> {
    PageBean<Map<String ,String>> findStatisticalData(SignInEntity data);

    List<Map<String ,String>> findStatisticalDataForExcel(SignInEntity data);

    PageBean<SignInEntity> findCheckData(SignInEntity data);

    Result deleteByCourseId(String courseId);
}
