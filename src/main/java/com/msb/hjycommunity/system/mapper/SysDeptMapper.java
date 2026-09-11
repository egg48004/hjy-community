package com.msb.hjycommunity.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.hjycommunity.system.domain.SysDept;

import java.util.List;

public interface SysDeptMapper extends BaseMapper<SysDept> {
    List<SysDept> selectDeptList(SysDept sysDept);
}
