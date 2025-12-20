package com.msb.hjycommunity.common.core.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private String searchValue;
    @TableField(exist = false)
    private Map<String, Object> params;
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;

    private String remark;
}
