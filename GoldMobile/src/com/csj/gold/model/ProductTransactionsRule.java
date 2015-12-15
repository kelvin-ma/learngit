package com.csj.gold.model;

import java.util.Date;

public class ProductTransactionsRule {
    private Long id;

    private Long traMaxNum;

    private Integer traMinNum;

    private Integer traAddNum;

    private Integer traDirection;

    private Long prouductId;

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

    public Long getTraMaxNum() {
        return traMaxNum;
    }

    public void setTraMaxNum(Long traMaxNum) {
        this.traMaxNum = traMaxNum;
    }

    public Integer getTraMinNum() {
        return traMinNum;
    }

    public void setTraMinNum(Integer traMinNum) {
        this.traMinNum = traMinNum;
    }

    public Integer getTraAddNum() {
        return traAddNum;
    }

    public void setTraAddNum(Integer traAddNum) {
        this.traAddNum = traAddNum;
    }

    public Integer getTraDirection() {
        return traDirection;
    }

    public void setTraDirection(Integer traDirection) {
        this.traDirection = traDirection;
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