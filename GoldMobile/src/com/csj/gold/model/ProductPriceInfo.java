package com.csj.gold.model;

import java.util.Date;

public class ProductPriceInfo {
    private Long id;

    private Long productIssuedPrice;

    private Integer productMoneyType;

    private Long productSellFee;

    private Integer productFeeUnit;

    private Long productIssuedTotal;

    private Integer productIssuedUnit;

    private Long productId;

    private Integer version;

    private Date createDate;

    private Long createUser;

    private Date updateDate;

    private Long updateUser;

    private Integer isDel;

    private Integer isForbidden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductIssuedPrice() {
        return productIssuedPrice;
    }

    public void setProductIssuedPrice(Long productIssuedPrice) {
        this.productIssuedPrice = productIssuedPrice;
    }

    public Integer getProductMoneyType() {
        return productMoneyType;
    }

    public void setProductMoneyType(Integer productMoneyType) {
        this.productMoneyType = productMoneyType;
    }

    public Long getProductSellFee() {
        return productSellFee;
    }

    public void setProductSellFee(Long productSellFee) {
        this.productSellFee = productSellFee;
    }

    public Integer getProductFeeUnit() {
        return productFeeUnit;
    }

    public void setProductFeeUnit(Integer productFeeUnit) {
        this.productFeeUnit = productFeeUnit;
    }

    public Long getProductIssuedTotal() {
        return productIssuedTotal;
    }

    public void setProductIssuedTotal(Long productIssuedTotal) {
        this.productIssuedTotal = productIssuedTotal;
    }

    public Integer getProductIssuedUnit() {
        return productIssuedUnit;
    }

    public void setProductIssuedUnit(Integer productIssuedUnit) {
        this.productIssuedUnit = productIssuedUnit;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
}