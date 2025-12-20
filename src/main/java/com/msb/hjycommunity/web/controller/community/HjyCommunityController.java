package com.msb.hjycommunity.web.controller.community;

import com.msb.hjycommunity.common.core.controller.BaseController;
import com.msb.hjycommunity.common.core.domain.BaseResponse;
import com.msb.hjycommunity.common.core.page.PageResult;
import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.service.HjyCommunityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/community")
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

}

