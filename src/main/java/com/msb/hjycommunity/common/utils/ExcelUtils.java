package com.msb.hjycommunity.common.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ExcelUtils {
    public static void exportExcel(List<?> list, Class<?> pojoClass, String filename,
                                   HttpServletResponse response, ExportParams exportParams){
    //数据列表 pojo类型 导出的名称 response 导出参数
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,pojoClass,list);
        downLoadExcel(filename, response, workbook);

    }

    private static void downLoadExcel(String filename, HttpServletResponse response, Workbook workbook) {


    }

}
