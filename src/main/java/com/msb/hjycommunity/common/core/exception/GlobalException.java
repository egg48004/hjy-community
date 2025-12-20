package com.msb.hjycommunity.common.core.exception;

import com.msb.hjycommunity.common.core.domain.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//抛出自定义异常-》
//系统捕捉并把异常信息取出来传入新生成的Base Respond实例，再返回前端
//于是前端收到一个统一格式的json对象，里面包含着自定义报错信息。
//所以不是直接转到了自定义报错，而是再包了一层，返回了统一响应对象
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse baseExceptionHandler(Exception e){
        return BaseResponse.fail(e.getMessage());
    }

}
