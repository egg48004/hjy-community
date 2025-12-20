package com.msb.hjycommunity.community.service;

import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;

import java.util.List;

public interface HjyCommunityService {

    List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity);
    int insertHiyCommunity(HjyCommunity hjyCommunity);
}
