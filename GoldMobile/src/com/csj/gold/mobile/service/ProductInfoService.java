package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.ProductInfo;

public interface ProductInfoService {

	ProductInfo searchById(Long id);
	
	List<ProductInfo> searchByParameters(ProductInfo productInfo);
	
	int insert(ProductInfo productInfo);

	int update(ProductInfo productInfo);
	
	int delete(Long id);
	
	int forbidden(Long id);
	
}