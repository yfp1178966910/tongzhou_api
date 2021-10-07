package com.combanc.cas.client.springboot.enums;

/**
 * 对课程排序对字段枚举
 */

public enum CourseSortFieldEnum {

    COURSE_CREATE_TIME,

    COURSE_START_TIME,

    CONCUR_SIGN_UP;

    public static boolean isValidValue(String value) {
        for (CourseSortFieldEnum courseSortFieldEnum : CourseSortFieldEnum.values()) {
            if (courseSortFieldEnum.name().equals(value)) {
                return true;
            }
        }
        return false;
    }

}
