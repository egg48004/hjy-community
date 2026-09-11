package com.msb.hjycommunity.community.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class HjyCommunityVo implements Serializable {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long communityId;

    private String communityName;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
