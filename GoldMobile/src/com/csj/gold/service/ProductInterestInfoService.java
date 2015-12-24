package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.ProductInterestInfo;
import com.csj.gold.utils.page.Page;

public interface ProductInterestInfoService {
	int add(ProductInterestInfo productInterestInfo);

	int update(ProductInterestInfo productInterestInfo);

	int delete(ProductInterestInfo productInterestInfo);

	int forbidden(ProductInterestInfo productInterestInfo);

	List<ProductInterestInfo> searchByParameters(Page page,ProductInterestInfo productInterestInfo);

	ProductInterestInfo searchByPrimaryKey(ProductInterestInfo productInterestInfo);
}
