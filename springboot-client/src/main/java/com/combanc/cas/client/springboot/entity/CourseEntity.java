package com.combanc.cas.client.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity extends BaseDto<CourseEntity>{
    private String id;
    private String courseTitle;
    private String courseTopic;//*本次新增  课程主题
    private String courseType;//*本次新增  课程类型 1 学科培训课程 2研修活动
    private String teacher;//课程教师
    private String coverUrl;//封面地址
    private String courseStartDate;//起始日期
    private String courseEndDate;//结束日期
    private String courseStartTime;//上课时间
    private String courseEndTime;
    private String lessonPeriod;//课时
    private String subject;//学科
    private String grade;//学段年级
    private String weeks;//星期

    private String student;//参加对象
    private String longitude;//经度
    private String latitude;//纬度
    private String appendixUrl;//附件地址
    private String recommend;//详情
    private String isShow;// 0 未上架   1 已上架
    private String courseStates;//课程状态  0 准备开课   1 开课中   2 课程结束
    private Integer maxSignUp;//最大人数
    private Integer concurSignUp;//当前人数
    private String classRoom;//*本次新增  教室 ：没在教室就是0，在教室就是教室房间号
    private String location;//授课地点
    private Integer isDelete;//删除标识

    private String courseCreateTime;

    private String sortField;  // 排序字段名称
    private String sortOrder = "DESC";  // 排序顺序，des/desc，正序逆序, 默认逆序
}
