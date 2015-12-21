package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.ProductType;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(ProductType productType);

    int insertSelective(ProductType productType);

    ProductType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductType productType);

    int updateByPrimaryKey(ProductType productType);

	int forbiddenByPrimaryKey(Long id);
	
	List<ProductType> selectByParameters(ProductType productType);
}