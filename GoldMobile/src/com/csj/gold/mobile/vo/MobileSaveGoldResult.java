package com.csj.gold.mobile.vo;

import java.util.List;


public class MobileSaveGoldResult extends MobileResult{
	private List<MobileShopVO> shopDatas = null;
	
	private List<MobileShopVO> bankDatas = null;

	public List<MobileShopVO> getShopDatas() {
		return shopDatas;
	}

	public void setShopDatas(List<MobileShopVO> shopDatas) {
		this.shopDatas = shopDatas;
	}

	public List<MobileShopVO> getBankDatas() {
		return bankDatas;
	}

	public void setBankDatas(List<MobileShopVO> bankDatas) {
		this.bankDatas = bankDatas;
	}


	
}
