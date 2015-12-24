package com.csj.gold.model;

import java.util.Date;

public class SysAccountTransactions {
    private Long id;

    private Long accoutId;

    private Long transactionMoney;

    private Integer transactionSwiftNo;

    private Integer transactionType;

    private String orderNumber;

    private Date createDate;

    private Date updateDate;

    private Long createUser;

    private Long updateUser;

    private Integer isDel;

    private Integer isForbidden;
    
    private Integer version;
    
    public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(Long accoutId) {
        this.accoutId = accoutId;
    }

    public Long getTransactionMoney() {
        return transactionMoney;
    }

    public void setTransactionMoney(Long transactionMoney) {
        this.transactionMoney = transactionMoney;
    }

    public Integer getTransactionSwiftNo() {
        return transactionSwiftNo;
    }

    public void setTransactionSwiftNo(Integer transactionSwiftNo) {
        this.transactionSwiftNo = transactionSwiftNo;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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