package com.msb.hjycommunity.springsecurity_example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecurityController {



    @PreAuthorize("hasAuthority('system:community:list')") //用于检查用户是否有指定权限
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Security!";
    }

    @PreAuthorize("hasAuthority('system:role:list')") //用于检查用户是否有指定权限
    @RequestMapping("/ok")
    public String ok() {
        return "ok Security!";
    }
}