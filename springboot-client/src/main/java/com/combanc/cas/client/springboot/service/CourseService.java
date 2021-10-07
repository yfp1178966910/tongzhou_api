package com.combanc.cas.client.springboot.service;

import com.combanc.cas.client.springboot.entity.CourseEntity;
import com.combanc.cas.client.springboot.entity.Result;

public interface CourseService extends BaseService<CourseEntity> {
    Result orderByCreateTime(CourseEntity data);

    Result orderByTeacher(CourseEntity data);

    Result orderByHot(CourseEntity data);
    Result selectCourseByTimeAndClassRoom(CourseEntity data);
}
