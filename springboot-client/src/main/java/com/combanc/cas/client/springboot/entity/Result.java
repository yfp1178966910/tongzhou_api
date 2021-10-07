package com.combanc.cas.client.springboot.entity;


import com.combanc.cas.client.springboot.enums.ResultCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class Result {

    private String code;

    private String msg;

    private Object result = Collections.EMPTY_MAP;

    public Result(ResultCode resultCode) {
        this.code = resultCode.getValue();
        this.msg = resultCode.getDesc();
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultCode resultCode, Object result) {
        this.code = resultCode.getValue();
        this.msg = resultCode.getDesc();
        this.result = result;
    }

    public Result(String status, String msg, Object result) {
        this.code = status;
        this.msg = msg;
        this.result = result;
    }

    public Result(ResultCode resultCode, String msg, Object result) {
        this.code = resultCode.getValue();
        this.msg = msg;
        this.result = result;
    }


    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static Result success(Object result) {
        return new Result(ResultCode.SUCCESS, result);
    }

    public static Result failed() {
        return new Result(ResultCode.FAILED, ResultCode.FAILED.getDesc());
    }

    public static Result failed(String msg) {
        return new Result(ResultCode.FAILED.getValue(), msg, Collections.EMPTY_MAP);
    }

    public static Result build(ResultCode resultCode) {
        return new Result(resultCode);
    }

    public static Result build(ResultCode resultCode, Object result) {
        return new Result(resultCode, result);
    }

    public static Result build(ResultCode resultCode, String msg) {
        return new Result(resultCode.getValue(), msg);
    }

    public static Result build(ResultCode resultCode, String msg, Object result) {
        return new Result(resultCode.getValue(), msg, result);
    }

    @Override
    public String toString(){
        return "Result: {code:"+this.code+','+"msg:"+this.msg+','+"result:"+this.result+"}";
    }
}
