package com.msb.hjycommunity.common.core.exception;



//这里是自己定义的异常类
public class BaseException extends RuntimeException{
    private String code;
    private String message;

    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
