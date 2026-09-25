package com.msb.hjycommunity.springsecurity_example.config;

import com.msb.hjycommunity.springsecurity_example.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//启用全局方法级别的安全控制 pre表示在方法执行前进行权限校验
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;



    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


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
        //将自定义认证过滤器添加到过滤器链
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //配置异常处理器
        http.exceptionHandling()
                //认证处理
                .authenticationEntryPoint(authenticationEntryPoint)
                //授权处理
                .accessDeniedHandler(accessDeniedHandler);


    }



}





























