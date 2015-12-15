package com.csj.gold.model;

import java.util.Date;

public class UserProduct {
    private Long id;

    private String prouductName;

    private Byte yearInterestRate;

    private Byte dayIntserestRate;

    private Date buyDate;

    private Date expireDate;

    private Long expireIntserest;

    private Long prouductType;

    private Long prouductId;

    private Date createDate;

    private Long createUser;

    private Date updateDate;

    private Long updateUser;

    private Integer isForbidden;

    private Integer isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProuductName() {
        return prouductName;
    }

    public void setProuductName(String prouductName) {
        this.prouductName = prouductName == null ? null : prouductName.trim();
    }

    public Byte getYearInterestRate() {
        return yearInterestRate;
    }

    public void setYearInterestRate(Byte yearInterestRate) {
        this.yearInterestRate = yearInterestRate;
    }

    public Byte getDayIntserestRate() {
        return dayIntserestRate;
    }

    public void setDayIntserestRate(Byte dayIntserestRate) {
        this.dayIntserestRate = dayIntserestRate;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getExpireIntserest() {
        return expireIntserest;
    }

    public void setExpireIntserest(Long expireIntserest) {
        this.expireIntserest = expireIntserest;
    }

    public Long getProuductType() {
        return prouductType;
    }

    public void setProuductType(Long prouductType) {
        this.prouductType = prouductType;
    }

    public Long getProuductId() {
        return prouductId;
    }

    public void setProuductId(Long prouductId) {
        this.prouductId = prouductId;
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
}