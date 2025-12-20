package com.msb.hjycommunity.system.domain;

import java.io.Serializable;

/**
 * 区域表(SysArea)实体类
 *
 * @author makejava
 * @since 2025-12-10 21:54:10
 */
public class SysArea implements Serializable {
    private static final long serialVersionUID = 657204324286693869L;
    /**
     * 唯一主键
     */
    private Integer id;
    /**
     * 城市编码
     */
    private Integer code;
    /**
     * 城市名称
     */
    private String name;
    /**
     * 城市父ID
     */
    private Integer parentCode;

    public SysArea() {
    }

    public SysArea(Integer id, Integer code, String name, Integer parentid) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.parentCode = parentid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        return "SysArea{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", parentid=" + parentCode +
                '}';
    }
}