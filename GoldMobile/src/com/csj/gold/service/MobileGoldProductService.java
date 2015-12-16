package com.csj.gold.service;

import java.util.List;

import com.csj.gold.mobile.vo.MobileGoldProductVO;
import com.csj.gold.model.bean.MobileGoldProduct;


public interface MobileGoldProductService {
	public List<MobileGoldProduct> searchAll();
	
	public List<MobileGoldProduct> searchByParameters(MobileGoldProduct mobileGoldProduct);
	
}
