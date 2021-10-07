package com.combanc.cas.client.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpEntity extends BaseDto<SignUpEntity> {
//报名表

    private String id;
    private String courseId;//课程id
    private String userId;//用户id
    private String signUpType; // 0 研修员独立组织活动  1 外聘专家开展活动
    private Integer scoreA;//细分评分
    private Integer scoreB;
    private Integer scoreC;
    private Integer scoreD;
    private Integer scoreE;
    private String year;
    private BigDecimal getSum;//获取的签到学分
    private Integer scoreSum;//总分
    private String suggestion;//评分意见


    private String courseStartTime;//上课时间
    private String courseEndTime;
    private String courseTitle;
    private Integer concurSignUp;//当前人数
    private String longitude;//经度
    private String latitude;//纬度
    private String location;//授课地点
    private String userName;//用户名
    private String trueName;//真名
    private String schoolName;//学校名
    private String userType;//
    private String courseStates;//课程状态  0 准备开课   1 开课中   2 课程结束



}
