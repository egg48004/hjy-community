package com.msb.hjycommunity.springsecurity_example.exception;

import com.alibaba.fastjson.JSON;
import com.msb.hjycommunity.common.constant.HttpStatus;
import com.msb.hjycommunity.common.utils.WebUtils;
import com.msb.hjycommunity.springsecurity_example.common.ResponseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult("权限不足禁止访问" ,HttpStatus.FORBIDDEN);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
