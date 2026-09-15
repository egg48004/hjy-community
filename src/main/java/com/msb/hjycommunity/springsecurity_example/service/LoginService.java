package com.msb.hjycommunity.springsecurity_example.service;

import com.msb.hjycommunity.springsecurity_example.common.ResponseResult;
import com.msb.hjycommunity.springsecurity_example.entity.SysUser;

public interface LoginService {
    ResponseResult login(SysUser sysUser);

    ResponseResult logout();
}
