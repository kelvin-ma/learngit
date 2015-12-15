package com.csj.gold.model;

import java.util.Date;

public class SysDictionary {
    private Integer id;

    private String dicName;

    private Integer dicType;

    private Integer dicPid;

    private Integer dicOrder;

    private String dicValue;

    private String remark;

    private Date createDate;

    private Long createUser;

    private Date updateDate;

    private Long updateUser;

    private Integer isDel;

    private Integer isForbidden;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }

    public Integer getDicType() {
        return dicType;
    }

    public void setDicType(Integer dicType) {
        this.dicType = dicType;
    }

    public Integer getDicPid() {
        return dicPid;
    }

    public void setDicPid(Integer dicPid) {
        this.dicPid = dicPid;
    }

    public Integer getDicOrder() {
        return dicOrder;
    }

    public void setDicOrder(Integer dicOrder) {
        this.dicOrder = dicOrder;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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