package com.combanc.cas.client.springboot.enums;

public enum SortOrderEnum {
    ASC,  // 从小到大

    DESC;  // 从大到小

    public static boolean isValidValue(String value) {
        for (SortOrderEnum sortOrderEnum : SortOrderEnum.values()) {
            if (sortOrderEnum.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
