package com.msb.hjycommunity.common.core.domain;

public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;


    public static <T> BaseResponse<T> success(T data){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.data = data;
        baseResponse.code = ResultCode.SUCCESS.getCode();
        baseResponse.message = ResultCode.SUCCESS.getMessage();
        return baseResponse;

    }
    public static <T> BaseResponse<T> fail(String message){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.code = ResultCode.ERROR.getCode();
        baseResponse.message = message;
        return baseResponse;
    }
    public static <T> BaseResponse<T> fail(String code, String message){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.code = code;
        baseResponse.message = message;
        return baseResponse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
