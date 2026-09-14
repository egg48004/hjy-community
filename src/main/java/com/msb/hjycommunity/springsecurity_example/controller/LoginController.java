package com.msb.hjycommunity.springsecurity_example.controller;

import com.msb.hjycommunity.springsecurity_example.common.ResponseResult;
import com.msb.hjycommunity.springsecurity_example.entity.SysUser;
import com.msb.hjycommunity.springsecurity_example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody SysUser sysUser){


        return loginService.login(sysUser);
    }

}
