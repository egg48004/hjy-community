package com.msb.hjycommunity.common.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msb.hjycommunity.common.constant.HttpStatus;
import com.msb.hjycommunity.common.core.domain.BaseResponse;
import com.msb.hjycommunity.common.core.page.PageDomain;
import com.msb.hjycommunity.common.core.page.PageResult;
import com.msb.hjycommunity.common.utils.ServletUtils;

import java.util.List;

public class BaseController {
    private static final String PAGE_NUM = "pageNum";
    private static final String PAGE_SIZE = "pageSize";

    protected static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNumber(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        return pageDomain;
    }

    protected void starPage(){
        PageDomain pageDomain = getPageDomain();
        Integer pageNumber = pageDomain.getPageNumber();
        Integer pageSize = pageDomain.getPageSize();
        if (pageSize != null && pageNumber != null){
            PageHelper.startPage(pageNumber, pageSize);
        }
    }

    protected PageResult getDate(List<?> lists){
        PageResult pageResult = new PageResult();
        pageResult.setTotal(new PageInfo<>(lists).getTotal());
        pageResult.setCode(HttpStatus.SUCCESS);
        pageResult.setRows(lists);
        pageResult.setMsg("分页查询成功");
        return pageResult;
    }

    protected BaseResponse toAjax(int rows){
        return rows > 0 ? BaseResponse.success(rows) : BaseResponse.fail("操作失败");
    }

}

















