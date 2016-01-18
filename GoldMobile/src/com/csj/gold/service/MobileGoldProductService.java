package com.csj.gold.service;

import java.util.List;

import com.csj.gold.mobile.vo.MobileGoldTranParams;
import com.csj.gold.model.bean.MobileGoldProduct;
import com.csj.gold.utils.page.Page;


public interface MobileGoldProductService {
	public MobileGoldProduct getProductById(Long id);
	
	public List<MobileGoldProduct> searchAll();
	
	public List<MobileGoldProduct> searchByParameters(Page page,MobileGoldProduct mobileGoldProduct);
	
	/**
	 * 检查产品是否符合交易条件
	 * 包括以下条件
	 * 起买限制，最小追加单位限制，最大购买数量限制，和产品剩余份额限制
	 * @return 
	 */
	public boolean checkProductConditions(MobileGoldTranParams tranParams);
	
}
