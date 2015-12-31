package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.bean.MobileShop;

public interface MobileShopService {
	public List<MobileShop> searchAll();

	public List<MobileShop> searchAllSaveShop();
	
	public List<MobileShop> searchAllPickShop();
	
}
