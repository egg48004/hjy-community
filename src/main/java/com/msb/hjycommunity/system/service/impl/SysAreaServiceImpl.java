package com.msb.hjycommunity.system.service.impl;

import com.msb.hjycommunity.system.domain.SysArea;
import com.msb.hjycommunity.system.domain.dto.SysAreaDto;
import com.msb.hjycommunity.system.mapper.SysAreaMapper;
import com.msb.hjycommunity.system.service.SysAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SysAreaServiceImpl implements SysAreaService {
    @Resource
    private SysAreaMapper sysAreaMapper;

    @Override
    public List<SysAreaDto> findAreaAsTree() {
        List<SysArea> list = sysAreaMapper.findAll();

        return list.stream()
                .filter(area -> area.getParentCode().equals(0))//把节点为0的根节点先找出来，开启第一轮递归
                .map(area -> {
                    SysAreaDto sysAreaDto = new SysAreaDto();
                    sysAreaDto.setCode(area.getCode());
                    sysAreaDto.setName(area.getName());
                    sysAreaDto.setChildren(getChildrenArea(sysAreaDto, list));//此为递归方法,递归找子类
                    return sysAreaDto;
                }).collect(Collectors.toList());//把每一个装好子类的第一层dto返回

    }
    //传入第一层节点dto合集，传入整个数据合集
    private List<SysAreaDto> getChildrenArea(SysAreaDto sysAreaDto, List<SysArea> list) {
        //新建节点dto合集作为子集
        List<SysArea> subAreas = list.stream()//此为判断语句：如果所有合集里有节点等于传入的父节点合集，返回此数据合集（即为子合集）
                .filter(area -> area.getParentCode().equals(sysAreaDto.getCode()))
                .collect(Collectors.toList());


        if (subAreas != null && subAreas.size() != 0){
            return subAreas.stream().map(area -> {
                SysAreaDto subAreaDto = new SysAreaDto();
                subAreaDto.setName(area.getName());
                subAreaDto.setCode(area.getCode());
                subAreaDto.setChildren(getChildrenArea(subAreaDto, list));
                return subAreaDto;
            }).collect(Collectors.toList());

        }

        return null;
    }
}
