package com.csj.gold.model;

import java.util.Date;

public class ProductInfo {
    private Long id;

    private String productName;

    private String productIntroduct;

    private Long productContractId;

    private Date productStartData;

    private Date productEndData;

    private Long productType;

    private Integer productStatus;

    private Date createDate;

    private Long createUser;

    private Date updateDate;

    private Long updateUser;

    private Integer isForbidden;

    private Integer isDel;

    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductIntroduct() {
        return productIntroduct;
    }

    public void setProductIntroduct(String productIntroduct) {
        this.productIntroduct = productIntroduct == null ? null : productIntroduct.trim();
    }

    public Long getProductContractId() {
        return productContractId;
    }

    public void setProductContractId(Long productContractId) {
        this.productContractId = productContractId;
    }

    public Date getProductStartData() {
        return productStartData;
    }

    public void setProductStartData(Date productStartData) {
        this.productStartData = productStartData;
    }

    public Date getProductEndData() {
        return productEndData;
    }

    public void setProductEndData(Date productEndData) {
        this.productEndData = productEndData;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
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

    public Integer getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(Integer isForbidden) {
        this.isForbidden = isForbidden;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}