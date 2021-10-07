package com.combanc.cas.client.springboot.dao;

import com.combanc.cas.client.springboot.entity.CourseEntity;
import com.combanc.cas.client.springboot.entity.SignUpEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SignUpDao extends BaseDao<SignUpEntity> {
    int findPgCountByGroup(SignUpEntity dto);

    List<Map<String,Object>> findPgListByGroup(SignUpEntity dto);

    Integer deleteByCourseId(String courseId);

    List<Map<String, Object>> selectGetSumByYearByUser(SignUpEntity dto);

    List<Map<String, Object>> selectCourseByYearAndUser(SignUpEntity dto);
    List<CourseEntity> selectCourseByUserAndCourseTime(SignUpEntity dto);
}
