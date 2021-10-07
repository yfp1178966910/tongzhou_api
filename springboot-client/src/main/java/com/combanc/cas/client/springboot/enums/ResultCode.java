package com.combanc.cas.client.springboot.enums;

/**
 * 状态码
 *
 * @author
 */
public enum ResultCode {

    SUCCESS("请求成功!", "200"),

    FAILED("服务器内部错误!", "500"),

    PARAM_ERROR("参数错误!", "400"),

    DUPLICATE_DATA("重复数据!", "100"),

    VIEW_ERROR("/errors", "600"),

    METHOD_NOT_ALLOWED("不支持的HTTP方法请求!","405"),

    UNSUPPORTED_MEDIA_TYPE("不支持的HTTP类型请求!","415"),

    TIMEOUT("请求超时!", "408"),

    CONFLICT("主键重复!", "409"),

    INSUFFICIENT_SPACE_ON_RESOURCE("空间资源不足!", "419"),

    SERVICE_UNAVAILABLE("无法提供服务!","503"),

    TOKEN_INVALID("token过期","301"),

    LOGIN_TIMEOUT("登录超时","300");


    /**
     * 描述
     */
    private String desc;

    /**
     * 枚举值
     */
    private String value;

    ResultCode(String desc, String value) {
        this.value = value;
        this.desc = desc;
    }

    public static ResultCode getEnum(String value) {
        ResultCode resultEnum = null;
        ResultCode[] enumAry = ResultCode.values();
        for (int i = 0; i < enumAry.length; i++) {
            if (enumAry[i].getValue().equals(value)) {
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}