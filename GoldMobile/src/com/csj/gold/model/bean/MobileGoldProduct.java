package com.csj.gold.model.bean;

import com.sun.istack.internal.NotNull;

public class MobileGoldProduct {
	// 产品ID
	private Long productId;
	// 产品名称
	private String productName;
	// 起投金额
	private double traMinNum;
	// 最大投资额
	private double traMaxNum;
	// 最低追加额
	private double traAddNum;
	// 日利率
	private double pInterestRateDay;
	// 月利率
	private double pInterestRateMonth;
	// 年利率
	private double pInterestRateYear;
	// 计息模型
	private int pInterestModel;
	// 持续天数
	private int pExpiryDay;
	// 持续约束
	private int pExpiryMonth;
	// 持续年数
	private int pExpiryYear;
	// 图片地址
	private String imageFilePath;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getTraMinNum() {
		return traMinNum;
	}

	public void setTraMinNum(double traMinNum) {
		this.traMinNum = traMinNum;
	}

	public double getTraMaxNum() {
		return traMaxNum;
	}

	public void setTraMaxNum(double traMaxNum) {
		this.traMaxNum = traMaxNum;
	}

	public double getTraAddNum() {
		return traAddNum;
	}

	public void setTraAddNum(double traAddNum) {
		this.traAddNum = traAddNum;
	}

	public double getpInterestRateDay() {
		return pInterestRateDay;
	}

	public void setpInterestRateDay(double pInterestRateDay) {
		this.pInterestRateDay = pInterestRateDay;
	}

	public double getpInterestRateMonth() {
		return pInterestRateMonth;
	}

	public void setpInterestRateMonth(double pInterestRateMonth) {
		this.pInterestRateMonth = pInterestRateMonth;
	}

	public double getpInterestRateYear() {
		return pInterestRateYear;
	}

	public void setpInterestRateYear(double pInterestRateYear) {
		this.pInterestRateYear = pInterestRateYear;
	}

	public int getpInterestModel() {
		return pInterestModel;
	}

	public void setpInterestModel(int pInterestModel) {
		this.pInterestModel = pInterestModel;
	}

	public int getpExpiryDay() {
		return pExpiryDay;
	}

	public void setpExpiryDay(int pExpiryDay) {
		this.pExpiryDay = pExpiryDay;
	}

	public int getpExpiryMonth() {
		return pExpiryMonth;
	}

	public void setpExpiryMonth(int pExpiryMonth) {
		this.pExpiryMonth = pExpiryMonth;
	}

	public int getpExpiryYear() {
		return pExpiryYear;
	}

	public void setpExpiryYear(int pExpiryYear) {
		this.pExpiryYear = pExpiryYear;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

}
