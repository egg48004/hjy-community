package com.msb.hjycommunity.common.core.page;

public class PageDomain {
    private Integer pageNumber;//记录起始页数
    private Integer pageSize; //每页显示记录数

    public PageDomain() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageDomain(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Integer getPageNumber(Integer parameterToInt) {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize(Integer parameterToInt) {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
