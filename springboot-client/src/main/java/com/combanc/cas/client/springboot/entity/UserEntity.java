package com.combanc.cas.client.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseDto<UserEntity>{

    private String id;
    private Integer userType;//用户标识 0 学员  1 研修员  2 管理员 3超级管理员
    private String userName;
    private String trueName;
    private String schoolName;
    private String subject;//  教学科目
    private String JSESSIONID;//  登陆用jSessionId
    private String secretKey;
    private String grade;//学段
    private String phone;//电话

    //官网新增
    private String qqNumber;
    private String mail;
    private String introduction;//自我介绍
    private String headPortrait;//头像url
}
