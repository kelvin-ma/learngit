package com.csj.gold.model;

import java.util.Date;

public class ProductInterestInfo {
    private Long id;

    private Integer pIncomePaymentUnit;

    private Integer pInterestWay;

    private Integer pInterestRateDay;

    private Integer pInterestRateYear;

    private Integer pInterestRateMonth;

    private Integer pInterestModel;

    private Integer pExpiryDay;

    private Integer pExpiryMonth;

    private Byte pExpiryYear;

    private Long pProductId;

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

    public Integer getpIncomePaymentUnit() {
        return pIncomePaymentUnit;
    }

    public void setpIncomePaymentUnit(Integer pIncomePaymentUnit) {
        this.pIncomePaymentUnit = pIncomePaymentUnit;
    }

    public Integer getpInterestWay() {
        return pInterestWay;
    }

    public void setpInterestWay(Integer pInterestWay) {
        this.pInterestWay = pInterestWay;
    }

    public Integer getpInterestRateDay() {
        return pInterestRateDay;
    }

    public void setpInterestRateDay(Integer pInterestRateDay) {
        this.pInterestRateDay = pInterestRateDay;
    }

    public Integer getpInterestRateYear() {
        return pInterestRateYear;
    }

    public void setpInterestRateYear(Integer pInterestRateYear) {
        this.pInterestRateYear = pInterestRateYear;
    }

    public Integer getpInterestRateMonth() {
        return pInterestRateMonth;
    }

    public void setpInterestRateMonth(Integer pInterestRateMonth) {
        this.pInterestRateMonth = pInterestRateMonth;
    }

    public Integer getpInterestModel() {
        return pInterestModel;
    }

    public void setpInterestModel(Integer pInterestModel) {
        this.pInterestModel = pInterestModel;
    }

    public Integer getpExpiryDay() {
        return pExpiryDay;
    }

    public void setpExpiryDay(Integer pExpiryDay) {
        this.pExpiryDay = pExpiryDay;
    }

    public Integer getpExpiryMonth() {
        return pExpiryMonth;
    }

    public void setpExpiryMonth(Integer pExpiryMonth) {
        this.pExpiryMonth = pExpiryMonth;
    }

    public Byte getpExpiryYear() {
        return pExpiryYear;
    }

    public void setpExpiryYear(Byte pExpiryYear) {
        this.pExpiryYear = pExpiryYear;
    }

    public Long getpProductId() {
        return pProductId;
    }

    public void setpProductId(Long pProductId) {
        this.pProductId = pProductId;
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