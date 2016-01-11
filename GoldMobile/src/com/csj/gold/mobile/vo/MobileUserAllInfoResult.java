package com.csj.gold.mobile.vo;

public class MobileUserAllInfoResult extends MobileResult {
	private MobileUserAllInfoVO data = null;

	private String imagePath = null;

	public MobileUserAllInfoVO getData() {
		return data;
	}

	public void setData(MobileUserAllInfoVO data) {
		this.data = data;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
