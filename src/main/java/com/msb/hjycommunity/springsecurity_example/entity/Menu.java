package com.msb.hjycommunity.springsecurity_example.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName(value = "sys_menu")
public class Menu implements Serializable {
    @TableId
    private Long id;
    //菜单名
    private String menuName;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //菜单显示（0显示，1隐藏）
    private String visible;
    //菜单状态（0正常，1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;

    private String createBy;

    private String updateBy;

    private Date updateTime;

    private Date createTime;

    private String remark;



}




















