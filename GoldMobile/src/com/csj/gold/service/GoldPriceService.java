package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.GoldPrice;
import com.csj.gold.utils.page.Page;

public interface GoldPriceService {
	int add(GoldPrice goldPrice);

	int update(GoldPrice goldPrice);

	int delete(GoldPrice goldPrice);

	int forbidden(GoldPrice goldPrice);

	List<GoldPrice> searchByParameters(Page page,GoldPrice goldPrice);

	GoldPrice searchByPrimaryKey(GoldPrice goldPrice);
	
	GoldPrice searchRecentGoldPrice();
	
}
