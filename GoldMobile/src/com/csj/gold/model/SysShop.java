package com.csj.gold.model;

import java.util.Date;

public class SysShop {
    private Long id;

    private String shopName;

    private String shopAddress;

    private Double shopCoordinateEast;

    private Double shopCoordinateNorth;

    private Long shopImageId;

    private String shopPhone;

    private Date createDate;

    private Long createUser;

    private Date updateDate;

    private Long updateUser;

    private Integer isDel;

    private Integer isForbidden;
    
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Double getShopCoordinateEast() {
        return shopCoordinateEast;
    }

    public void setShopCoordinateEast(Double shopCoordinateEast) {
        this.shopCoordinateEast = shopCoordinateEast;
    }

    public Double getShopCoordinateNorth() {
        return shopCoordinateNorth;
    }

    public void setShopCoordinateNorth(Double shopCoordinateNorth) {
        this.shopCoordinateNorth = shopCoordinateNorth;
    }

    public Long getShopImageId() {
        return shopImageId;
    }

    public void setShopImageId(Long shopImageId) {
        this.shopImageId = shopImageId;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(Integer isForbidden) {
        this.isForbidden = isForbidden;
    }

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
    
}