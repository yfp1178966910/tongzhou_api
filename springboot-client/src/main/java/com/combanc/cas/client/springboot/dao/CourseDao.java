package com.combanc.cas.client.springboot.dao;

import com.combanc.cas.client.springboot.entity.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseDao extends BaseDao<CourseEntity> {
    List<CourseEntity> orderByCreateTime(CourseEntity data);

    List<Map<String, Object>> orderByTeacher(CourseEntity data);

    List<CourseEntity> orderByHot(CourseEntity data);
    List<CourseEntity> selectCourseByTimeAndClassRoom(CourseEntity data);
}
