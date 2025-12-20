package com.msb.hjycommunity.community.service.impl;

import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.mapper.HjyCommunityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HjyCommunityService implements com.msb.hjycommunity.community.service.HjyCommunityService {

    @Resource
    private HjyCommunityMapper hjyCommunityMapper;
    private static final String CODE_PREFIX = "COMMUNITY_";


    @Override
    public List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.queryList(hjyCommunity);
    }

    @Override
    public int insertHiyCommunity(HjyCommunity hjyCommunity) {
        hjyCommunity.setCommunityCode(CODE_PREFIX + System.currentTimeMillis());
        return hjyCommunityMapper.insert(hjyCommunity);
    }
}
