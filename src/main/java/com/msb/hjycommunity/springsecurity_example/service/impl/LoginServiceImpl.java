package com.msb.hjycommunity.springsecurity_example.service.impl;

import com.msb.hjycommunity.common.utils.JwtUtil;
import com.msb.hjycommunity.common.utils.RedisCache;
import com.msb.hjycommunity.springsecurity_example.common.ResponseResult;
import com.msb.hjycommunity.springsecurity_example.entity.LoginUser;
import com.msb.hjycommunity.springsecurity_example.entity.SysUser;
import com.msb.hjycommunity.springsecurity_example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(SysUser sysUser) {
       Authentication authenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUserName(),sysUser.getPassword());
       Authentication authentication = authenticationManager.authenticate(authenticationToken);

       if(Objects.isNull(authentication)){
           throw new RuntimeException("登录失败");
       }

       LoginUser loginUser = (LoginUser)authentication.getPrincipal();

       String userId = loginUser.getSysUser().getUserId().toString();
       String jwt = JwtUtil.createJWT(userId);

       redisCache.setCacheObject("login:" + userId,loginUser);

       Map<String,String> map = new HashMap<>();
       map.put("token",jwt);

        return new ResponseResult<Map<String, String>>(
                200,
                "登录成功",
                map
        );

    }

    @Override
    public ResponseResult logout() {//把token在redis里删除
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authenticationToken)){
            throw new RuntimeException("获取用户认证信息失败");

        }
        LoginUser loginUser = (LoginUser) authenticationToken.getPrincipal();
        Long userId = loginUser.getSysUser().getUserId();

        redisCache.deleteObject("login:" + userId);
        return new ResponseResult("注销成功", 200);


    }
}