package com.msb.hjycommunity.springsecurity_example.common;

import org.apache.poi.ss.formula.functions.T;

public class ResponseResult<T>  {
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //封装结果数据
    private T data;

    public ResponseResult(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
