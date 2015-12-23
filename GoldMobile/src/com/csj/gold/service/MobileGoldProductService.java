package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.bean.MobileGoldProduct;
import com.csj.gold.utils.page.Page;


public interface MobileGoldProductService {
	public List<MobileGoldProduct> searchAll();
	
	public List<MobileGoldProduct> searchByParameters(Page page,MobileGoldProduct mobileGoldProduct);
	
}
