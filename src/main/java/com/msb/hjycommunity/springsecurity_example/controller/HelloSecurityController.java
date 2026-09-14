package com.msb.hjycommunity.springsecurity_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloSecurityController {

    @GetMapping
    public String hello() {
        return "Hello Security!";
    }
}