package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.ProductInfo;
import com.csj.gold.utils.page.Page;

public interface ProductInfoService {
	int add(ProductInfo productInfo);

	int update(ProductInfo productInfo);

	int delete(ProductInfo productInfo);

	int forbidden(ProductInfo productInfo);

	List<ProductInfo> searchByParameters(Page page,ProductInfo productInfo);

	ProductInfo searchByPrimaryKey(ProductInfo productInfo);
}
