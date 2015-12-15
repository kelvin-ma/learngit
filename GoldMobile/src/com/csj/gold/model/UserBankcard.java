package com.csj.gold.model;

import java.util.Date;

public class UserBankcard {
    private Long id;

    private Integer bankCode;

    private String cardNumber;

    private Long userId;

    private Date createDate;

    private Date updateDate;

    private Long updateUser;

    private Long createUser;

    private Integer isDel;

    private Integer isForbidden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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