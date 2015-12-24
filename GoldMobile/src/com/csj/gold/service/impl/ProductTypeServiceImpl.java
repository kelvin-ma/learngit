package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.ProductTypeMapper;
import com.csj.gold.model.ProductType;
import com.csj.gold.service.ProductTypeService;
import com.csj.gold.utils.page.Page;

@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService{
	
	@Resource
	ProductTypeMapper productTypeMapper = null;

	@Override
	public int add(ProductType productType) {
		return productTypeMapper.insertSelective(productType);
	}

	@Override
	public int update(ProductType productType) {
		return productTypeMapper.updateByPrimaryKeySelective(productType);
	}

	@Override
	public int delete(ProductType productType) {
		return productTypeMapper.deleteByPrimaryKey(productType.getId());
	}

	@Override
	public int forbidden(ProductType productType) {
		return productTypeMapper.forbiddenByPrimaryKey(productType.getId());
	}

	@Override
	public List<ProductType> searchByParameters(Page page,ProductType productType) {
		page.setParameters(productType);
		List<ProductType> returnList = productTypeMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public ProductType searchByPrimaryKey(ProductType productType) {
		return productTypeMapper.selectByPrimaryKey(productType.getId());
	}

}
