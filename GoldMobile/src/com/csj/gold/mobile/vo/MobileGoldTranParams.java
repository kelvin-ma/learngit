package com.csj.gold.mobile.vo;

import java.util.Date;

public class MobileGoldTranParams extends MobileParams {
	//产品信息
	private Long productId;
	//单价信息
	private String  price;
	//数量
	private String  number;
	//总金额
	private String sumMoney;
 	//购买方式
	private String tranType;
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(String sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	
	
	
}
