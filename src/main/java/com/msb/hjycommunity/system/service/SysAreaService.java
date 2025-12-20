package com.msb.hjycommunity.system.service;

import com.msb.hjycommunity.system.domain.dto.SysAreaDto;

import java.util.List;

public interface SysAreaService {
    List<SysAreaDto> findAreaAsTree();
}
