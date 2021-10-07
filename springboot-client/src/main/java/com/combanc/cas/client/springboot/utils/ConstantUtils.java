package com.combanc.cas.client.springboot.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

@UtilityClass
public class ConstantUtils {
    public final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final String DATE_FORMAT="yyyy-MM-dd";
    public final String TIME_FORMAT="HH:mm:ss";
    public final SimpleDateFormat FORMAT_DATETIME_FORMAT= new SimpleDateFormat(DATETIME_FORMAT);
    public final Long ONE_HOUR_LONG=60*60*1000L;
    public final Long HALF_ONE_HOUR_LONG=30*60*1000L;
//"中心简介".equals(dto.getIntroduceType()) || "历史沿革"
    public final String UNIQUE_INTRODUCE_TYPE1= "中心简介";
    public final String UNIQUE_INTRODUCE_TYPE2= "历史沿革";
    public final BigDecimal UNIT_SCORE = new BigDecimal ("0.5");

    public final Integer USER_TEACHER = 0;
    public final Integer USER_RESEARCHER = 1;
    public final Integer USER_DIRECTOR = 2;//部室主任 权限向下兼容
    public final Integer USER_DEAN = 3;// 主管院长  权限向下兼容
    public final Integer USER_HEAD = 4;//权限向下兼容
    // 部室主任userType=2；主管院长userType=3；教务负责人userType=4

    public final String COURSE_STATES_0 = "0";
    public final String COURSE_STATES_1 = "1";
    public final String COURSE_STATES_2 = "2";
    public final String IN_STATES_UNDO ="0";
    public final String IN_STATES_NORMAL ="1";// 0 未签到  1 签到正常 2 迟到 3 补签审核中  4 补签成功
    public final String IN_STATES_LATE ="2";// 0 未签到  1 签到正常 2 迟到 3 补签审核中  4 补签成功
    public final String STATES_CHECKING ="3";// 0 未签到  1 签到正常 2 迟到 3 补签审核中  4 补签成功
    public final String STATES_CHECKED ="4";// 0 未签到  1 签到 正常 2 迟到 3 补签审核中  4 补签成功
    public final String STATES_UNCHECKED ="5";// 0 未签到  1 签到正常 2 迟到 3 补签审核中  4 补签成功 5 补签未通过审核

    public final String OUT_STATES_UNDO ="0";// 0 未签到  1 签到正常 2 早退 3 补签审核中  4 补签成功 5 补签未通过审核
    public final String OUT_STATES_NORMAL ="1";// 0 未签到  1 签到正常 2 早退 3 补签审核中  4 补签成功 5 补签未通过审核
    public final String OUT_STATES_EARLY ="2";// 0 未签到  1 签到正常 2 早退 3 补签审核中  4 补签成功 5 补签未通过审核
    public final Integer FLAG_ADD=0;
    public final Integer FLAG_SUBTRACT=1;
}
