package com.csj.gold.model;

import java.math.BigDecimal;
import java.util.Date;

public class GoldPrice {
    private Long id;

    private Double goldPrice;

    private Date effectiveStartTime;

    private Date effectiveEntTime;

    private Integer isDel;

    private Integer isForbidden;

    private String dataSource;

    private Date createDate;

    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(Double goldPrice) {
        this.goldPrice = goldPrice;
    }

    public Date getEffectiveStartTime() {
        return effectiveStartTime;
    }

    public void setEffectiveStartTime(Date effectiveStartTime) {
        this.effectiveStartTime = effectiveStartTime;
    }

    public Date getEffectiveEntTime() {
        return effectiveEntTime;
    }

    public void setEffectiveEntTime(Date effectiveEntTime) {
        this.effectiveEntTime = effectiveEntTime;
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

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}