package com.msb.hjycommunity.springsecurity_example.filter;


import com.msb.hjycommunity.common.utils.JwtUtil;
import com.msb.hjycommunity.common.utils.RedisCache;
import com.msb.hjycommunity.springsecurity_example.entity.LoginUser;
import io.jsonwebtoken.Claims;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 自定义认证过滤器，用来校验用户请求中携带的token
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {//过滤一次
    @Autowired
    private RedisCache redisCache;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");//拿token
        if (!StringUtils.hasText(token)){ //判断如果token为空直接放行，让后续的过滤器进行操作
            filterChain.doFilter(request,response);
            return; //返回响应的时候避免走下面的逻辑
        }
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject(); //拿到用户id（我在生成token的时候把id传入subject了）
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("非法token");
        }

        String redisKey = "login:" + userId;
        LoginUser loginUser = redisCache.getCacheObject(redisKey);
        if (Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        //拿到token
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null,loginUser.getAuthorities());
        //放进Context里
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //放行
        filterChain.doFilter(request,response);


    }
}

























