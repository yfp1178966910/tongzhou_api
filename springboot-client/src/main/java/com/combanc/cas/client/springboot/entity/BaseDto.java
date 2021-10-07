package com.combanc.cas.client.springboot.entity;

import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.util.Strings;

import java.io.Serializable;


/**
 * Created with Intellij IDEA
 *
 * @author qhl
 * Date 2018/6/1
 * Time 15:31
 */
@Getter
@Setter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseDto<T extends Object> implements Serializable {

    private static final long serialVersionUID = -858310483517209865L;
    /**
     * 动作 使用ActionEnum
     */
    private String action;
    /**
     * 偏移量
     */
    private Integer offset;

    private String keyword;

    /**
     * 分页数
     */
    private Integer limit;

    private Integer code;

    /**
     * 检查是否匹配
     *
     * @param actionEnum
     * @return
     */
    public boolean checkAction(ActionEnum actionEnum) {
        if (Strings.isNullOrEmpty(getAction())) {
            return false;
        }
        if (getAction().equals(actionEnum.getCode())) {
            return true;
        }
        return false;
    }



}
