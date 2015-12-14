package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.ProductType;

public interface ProductTypeService {

	ProductType searchById(Long id);
	
	List<ProductType> searchByParameters(ProductType productType);
	
	int insert(ProductType productType);

	int update(ProductType productType);
	
	int delete(Long id);
	
	int forbidden(Long id);
}