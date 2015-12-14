package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.ProductTypeMapper;
import com.csj.gold.mobile.model.ProductType;
import com.csj.gold.mobile.service.ProductTypeService;

@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

	@Resource
	private ProductTypeMapper productTypeMapper;
	
	public ProductType searchById(Long id){
		return productTypeMapper.selectByPrimaryKey(id);
	}
	
	@Transactional
	public int insert(ProductType productType) {
		return productTypeMapper.insert(productType);
	}
	
	@Transactional
	public int update(ProductType productType) {
		return productTypeMapper.updateByPrimaryKey(productType);
	}
	
	@Transactional
	public int delete(Long id){
		return productTypeMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return productTypeMapper.updateForbiddenByPrimaryKey(id);
	}
	
	public List<ProductType> searchByParameters(ProductType productType) {
		return productTypeMapper.selectByParameters(productType);
	}

}