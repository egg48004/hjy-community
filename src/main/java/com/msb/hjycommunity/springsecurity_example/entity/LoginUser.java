package com.msb.hjycommunity.springsecurity_example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class LoginUser implements UserDetails {

    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;

    private SysUser sysUser;

    private List<String> permissions; //存储权限的集合

    public LoginUser(SysUser sysUser, List<String> list) {
        this.sysUser = sysUser;
        this.permissions = list;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

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
        //将permissions集合中的String类型的权限信息转化为SimpleGrantedAuthority类型

//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (String permission: permissions){
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
//            authorities.add(simpleGrantedAuthority);
//        }

        if (authorities != null){
            return authorities;
        }

        //java8 (jdk1.8)语法完成
        authorities = permissions.stream().
                map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
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
