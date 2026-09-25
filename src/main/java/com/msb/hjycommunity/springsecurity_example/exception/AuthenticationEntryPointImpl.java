package com.msb.hjycommunity.springsecurity_example.exception;

import com.alibaba.fastjson.JSON;
import com.msb.hjycommunity.common.constant.HttpStatus;
import com.msb.hjycommunity.common.utils.WebUtils;
import com.msb.hjycommunity.springsecurity_example.common.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//自定义认证过程的异常处理
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult("认证失败请重新登录", HttpStatus.UNAUTHORIZED);
        String json = JSON.toJSONString(request);
        WebUtils.renderString(response,json);

    }
}




























