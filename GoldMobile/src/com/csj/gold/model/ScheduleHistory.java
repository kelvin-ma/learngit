package com.csj.gold.model;

import java.util.Date;

public class ScheduleHistory {
    private Long id;

    private Integer scheduleType;

    private Date shceduleDate;

    private Integer activedStatus;

    private Date shceduleActivedDate;

    private String shceduleCode;

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

    public Integer getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(Integer scheduleType) {
        this.scheduleType = scheduleType;
    }

    public Date getShceduleDate() {
        return shceduleDate;
    }

    public void setShceduleDate(Date shceduleDate) {
        this.shceduleDate = shceduleDate;
    }

    public Integer getActivedStatus() {
        return activedStatus;
    }

    public void setActivedStatus(Integer activedStatus) {
        this.activedStatus = activedStatus;
    }

    public Date getShceduleActivedDate() {
        return shceduleActivedDate;
    }

    public void setShceduleActivedDate(Date shceduleActivedDate) {
        this.shceduleActivedDate = shceduleActivedDate;
    }

    public String getShceduleCode() {
        return shceduleCode;
    }

    public void setShceduleCode(String shceduleCode) {
        this.shceduleCode = shceduleCode == null ? null : shceduleCode.trim();
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