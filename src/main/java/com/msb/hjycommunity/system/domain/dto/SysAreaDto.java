package com.msb.hjycommunity.system.domain.dto;

import java.io.Serializable;
import java.util.List;

public class SysAreaDto implements Serializable {
    private static final long uid = 1;
    private Integer code;
    private String name;
    private List<SysAreaDto> children;

    public SysAreaDto() {
    }

    public SysAreaDto(Integer code, String name, List<SysAreaDto> children) {
        this.code = code;
        this.name = name;
        this.children = children;
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

    public List<SysAreaDto> getChildren() {
        return children;
    }

    public void setChildren(List<SysAreaDto> children) {
        this.children = children;
    }
}
