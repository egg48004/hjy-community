package com.msb.hjycommunity.springsecurity_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//需要注入一个具体的encoder到spring容器，才能使用passwordEncoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    //用于配置HTTP请求的安全处理
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().//关闭csrf
                //不会去创建会话，每个请求都被视为独立的请求，无状态
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //定义请求的授权规则
                .and()
                //对登录接口允许匿名访问
                .authorizeRequests()
                //除上面以外的所有请求都需要鉴权验证
                .antMatchers("/user/login").anonymous()
                .anyRequest().authenticated();


    }



}





























