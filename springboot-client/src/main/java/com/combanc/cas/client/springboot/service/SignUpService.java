package com.combanc.cas.client.springboot.service;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.SignUpEntity;
import com.combanc.cas.client.springboot.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface SignUpService  extends BaseService<SignUpEntity> {
    PageBean<Map<String, Object>> selectScoreByAdmin(SignUpEntity dto);

    Result deleteByCourseId(String courseId);

    PageBean<Map<String, Object>> selectGetSumByYearByUser(SignUpEntity dto);

    List<Map<String, Object>> selectCourseByYearAndUser(SignUpEntity dto);
}
