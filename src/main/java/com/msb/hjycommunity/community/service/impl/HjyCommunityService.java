package com.msb.hjycommunity.community.service.impl;

import com.msb.hjycommunity.common.utils.OrikaUtils;
import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.domain.vo.HjyCommunityVo;
import com.msb.hjycommunity.community.mapper.HjyCommunityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    @Override
    public HjyCommunity selectHjyCommunityById(Long communityId) {
        return hjyCommunityMapper.selectById(communityId);
    }

    @Override
    public int updateHjyCommunity(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.updateById(hjyCommunity);
    }

    @Override
    public int deleteHjyCommunity(Long[] communityIds) {
        return hjyCommunityMapper.deleteBatchIds(Arrays.asList(communityIds));
    }

    @Override
    public List<HjyCommunityVo> queryPulDown(HjyCommunity hjyCommunity) {
        log.info(">>> [WHITEBOX][Service] queryPulDown 进入, hjyCommunity={}", hjyCommunity);
        List<HjyCommunityDto> dtoList = hjyCommunityMapper.queryList(hjyCommunity);
        log.info(">>> [WHITEBOX][Service] mapper.queryList 返回 dtoList.size={}", dtoList.size());
        //拷贝对象。。
        log.info(">>> [WHITEBOX][Service] 开始 stream + OrikaUtils.convert 逐条拷贝 DTO -> VO");
        List<HjyCommunityVo> voList = dtoList.stream().map(dto -> {
            log.info(">>> [WHITEBOX][Service] 正在转换 dto[{}], dtoClass={}, targetClass={}",
                    dto.getCommunityId(), dto.getClass().getName(), HjyCommunityVo.class.getName());
            HjyCommunityVo communityVo = OrikaUtils.convert(dto, HjyCommunityVo.class);
            log.info(">>> [WHITEBOX][Service] dto[{}] 转换完成 -> vo={}", dto.getCommunityId(), communityVo);
            return communityVo;
        }).collect(Collectors.toList());
        log.info(">>> [WHITEBOX][Service] queryPulDown 全部转换完成, voList.size={}", voList.size());

        return voList;
    }

}
