package com.csj.gold.dao;

import java.util.List;

import com.csj.gold.model.bean.MobileShop;

public interface MobileShopMapper {
	
	List<MobileShop> searchAll();

	List<MobileShop> searchAllSaveShop();
	
	List<MobileShop> searchAllPickShop();
}
