package com.csj.gold.model;

import java.util.Date;

public class SysAccount {
    private Long id;

    private Integer accountCode;

    private Long accountTotalMoney;

    private Integer accountType;

    private Integer accountMoneyType;

    private Integer accountStatus;

    private Long accountUserId;

    private Integer isDel;

    private Integer isForbidden;

    private Date createDate;

    private Date updateDate;

    private Long updateUser;

    private Long createUser;

    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(Integer accountCode) {
        this.accountCode = accountCode;
    }

    public Long getAccountTotalMoney() {
        return accountTotalMoney;
    }

    public void setAccountTotalMoney(Long accountTotalMoney) {
        this.accountTotalMoney = accountTotalMoney;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountMoneyType() {
        return accountMoneyType;
    }

    public void setAccountMoneyType(Integer accountMoneyType) {
        this.accountMoneyType = accountMoneyType;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getAccountUserId() {
        return accountUserId;
    }

    public void setAccountUserId(Long accountUserId) {
        this.accountUserId = accountUserId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}