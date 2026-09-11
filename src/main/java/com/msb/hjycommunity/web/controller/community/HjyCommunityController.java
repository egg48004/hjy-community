package com.msb.hjycommunity.web.controller.community;

import com.alibaba.druid.support.logging.Log;
import com.msb.hjycommunity.common.core.controller.BaseController;
import com.msb.hjycommunity.common.core.domain.BaseResponse;
import com.msb.hjycommunity.common.core.page.PageResult;
import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.domain.vo.HjyCommunityVo;
import com.msb.hjycommunity.community.service.HjyCommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/community")
@Slf4j
public class HjyCommunityController extends BaseController {
    @Resource
    private HjyCommunityService hjyCommunityService;
    @GetMapping("/list")
    public PageResult list(HjyCommunity hjyCommunity){
        starPage();
        List<HjyCommunityDto> hjyCommunityDtos = hjyCommunityService.queryList(hjyCommunity);

        return getDate(hjyCommunityDtos);
    }
    @PostMapping("add")
    public BaseResponse add(@RequestBody HjyCommunity hjyCommunity){
        return toAjax(hjyCommunityService.insertHiyCommunity(hjyCommunity));
    }

    @GetMapping("/{communityId}")// {communityId} is a path variable
    public BaseResponse getInfo(@PathVariable("communityId") Long communityId){
        return BaseResponse.success(hjyCommunityService.selectHjyCommunityById(communityId));
    }
    @PutMapping// HTTP PUT method indicating an update operation (semantic)
    public BaseResponse edit(@RequestBody HjyCommunity hjyCommunity){ //// @RequestBody is used to get parameters from the request body

        return toAjax(hjyCommunityService.updateHjyCommunity(hjyCommunity));
    }
    @DeleteMapping("/{communityIds}")
    public BaseResponse delete(@PathVariable Long[] communityIds){
        return toAjax(hjyCommunityService.deleteHjyCommunity(communityIds));
    }
    @GetMapping("/queryPullDown")
    public BaseResponse queryPullDown(HjyCommunity hjyCommunity){
        log.info("log() called with parameters => [hjyCommunity = {}]", hjyCommunity);
        List<HjyCommunityVo> voList = null;
        try{
            voList = hjyCommunityService.queryPulDown(hjyCommunity);
        } catch (Exception e) {
            log.warn("获取小区下拉列表失败！",e);
        }
        log.info("log() returned: {}", voList);
        return BaseResponse.success(voList);


    }

}

