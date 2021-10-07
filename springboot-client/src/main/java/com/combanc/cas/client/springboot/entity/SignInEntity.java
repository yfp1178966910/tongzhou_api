package com.combanc.cas.client.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*  签到表
 */
public class SignInEntity extends BaseDto<SignInEntity> {

    private String id;
    private String signUpId; // 报名id
    private String courseId; // 课程id
    private String userId; // 用户id
    private String date;//yyyy-mm-dd
    private String inTime;//签到 时间
    private String outTime;//签退 时间
    private String inStates;// 0 未签到  1 签到正常 2 迟到
    private String outStates;// 0 未签到  1 签退正常 2 早退
    private String inCheckStates;// 0 未申请补签 3 补签审核中  4 补签成功 5 补签未通过审核
    private String outCheckStates;//0 未申请补签 3 补签审核中  4 补签成功 5 补签未通过审核
    private String inRemark;//补签说明
    private String outRemark;//补签说明

    private String trueName;
    private String courseTitle;
    private String secretKey;
    private BigDecimal signInScore;

}
