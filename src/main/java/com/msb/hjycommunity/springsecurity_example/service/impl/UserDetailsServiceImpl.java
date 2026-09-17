package com.msb.hjycommunity.springsecurity_example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.msb.hjycommunity.springsecurity_example.entity.LoginUser;
import com.msb.hjycommunity.springsecurity_example.entity.SysUser;
import com.msb.hjycommunity.springsecurity_example.mapper.MenuMapper;
import com.msb.hjycommunity.springsecurity_example.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MenuMapper menuMapper;


    private final SysUserMapper sysUserMapper;

    public UserDetailsServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    //重写权限管理中的UserDetailsService类
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUserName,username);
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if (Objects.isNull(sysUser)){
            throw new RuntimeException("用户名或密码错误");

        }

        //todo 查询用户权限信息
        //ArrayList<String> list = new ArrayList<>(Arrays.asList("test"));

        //从数据库查询用户权限信息
        List<String> perms = menuMapper.selectPermsByUserId(sysUser.getUserId());


        //返回类型是UserDetails类型，需要返回自定义实现的类
        return new LoginUser(sysUser,perms);
    }
}
























