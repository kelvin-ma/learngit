package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.ProductType;

public interface SysProductTypeService {
	int add(ProductType productType);

	int update(ProductType productType);

	int delete(ProductType productType);

	int forbidden(ProductType productType);

	List<ProductType> searchByParameters(ProductType productType);

	ProductType searchByPrimaryKey(ProductType productType);
}
