package com.msb.hjycommunity.springsecurity_example.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class LoginUser implements UserDetails {

    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public LoginUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public LoginUser() {
    }

    /**
     * 用于获取用户被授予的权限，可以用于实现访问控制
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    //获取密码 用于密码验证
    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
    }
    //判断账户是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //用户账户是否被锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //用户凭证是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //用户是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }
}
