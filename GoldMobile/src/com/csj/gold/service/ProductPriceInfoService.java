package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.ProductPriceInfo;
import com.csj.gold.utils.page.Page;

public interface ProductPriceInfoService {
	int add(ProductPriceInfo productPriceInfo);

	int update(ProductPriceInfo productPriceInfo);

	int delete(ProductPriceInfo productPriceInfo);

	int forbidden(ProductPriceInfo productPriceInfo);

	List<ProductPriceInfo> searchByParameters(Page page,ProductPriceInfo productPriceInfo);

	ProductPriceInfo searchByPrimaryKey(ProductPriceInfo productPriceInfo);
}
