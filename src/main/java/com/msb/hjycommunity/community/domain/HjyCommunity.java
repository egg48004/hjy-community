package com.msb.hjycommunity.community.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.msb.hjycommunity.common.core.domain.BaseEntity;

//小区
public class HjyCommunity extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long communityId;

    private String communityName;
    private String communityCode;
    private String communityProvinceCode;
    private String communityCityCode;
    private String communityTownCode;
    private String communityDetailedAddress;
    private String longitude;
    private String latitude;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId; //物业id

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long communitySort; //物业id

    public HjyCommunity() {
    }

    @Override
    public String toString() {
        return "HjyCommunity{" +
                "communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", communityCode='" + communityCode + '\'' +
                ", communityProvinceCode='" + communityProvinceCode + '\'' +
                ", communityCityCode='" + communityCityCode + '\'' +
                ", communityTownCode='" + communityTownCode + '\'' +
                ", communityDetailedAddress='" + communityDetailedAddress + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", deptId=" + deptId +
                ", communitySort=" + communitySort +
                '}';
    }

    public HjyCommunity(Long communityId, String communityName, String communityCode, String communityProvinceCode, String communityCityCode, String communityTownCode, String communityDetailedAddress, String longitude, String latitude, Long deptId, Long communitySort) {
        this.communityId = communityId;
        this.communityName = communityName;
        this.communityCode = communityCode;
        this.communityProvinceCode = communityProvinceCode;
        this.communityCityCode = communityCityCode;
        this.communityTownCode = communityTownCode;
        this.communityDetailedAddress = communityDetailedAddress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.deptId = deptId;
        this.communitySort = communitySort;
    }

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

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getCommunityProvinceCode() {
        return communityProvinceCode;
    }

    public void setCommunityProvinceCode(String communityProvinceCode) {
        this.communityProvinceCode = communityProvinceCode;
    }

    public String getCommunityCityCode() {
        return communityCityCode;
    }

    public void setCommunityCityCode(String communityCityCode) {
        this.communityCityCode = communityCityCode;
    }

    public String getCommunityTownCode() {
        return communityTownCode;
    }

    public void setCommunityTownCode(String communityTownCode) {
        this.communityTownCode = communityTownCode;
    }

    public String getCommunityDetailedAddress() {
        return communityDetailedAddress;
    }

    public void setCommunityDetailedAddress(String communityDetailedAddress) {
        this.communityDetailedAddress = communityDetailedAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getCommunitySort() {
        return communitySort;
    }

    public void setCommunitySort(Long communitySort) {
        this.communitySort = communitySort;
    }
}
