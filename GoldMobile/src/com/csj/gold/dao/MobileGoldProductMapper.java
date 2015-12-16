package com.csj.gold.dao;

import java.util.List;

import com.csj.gold.model.bean.MobileGoldProduct;

public interface MobileGoldProductMapper {
	List<MobileGoldProduct> searchAll();
	List<MobileGoldProduct> searchByParameters(MobileGoldProduct mobileGoldProduct);
}
