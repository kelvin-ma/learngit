package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.ProductInfoMapper;
import com.csj.gold.mobile.model.ProductInfo;
import com.csj.gold.mobile.service.ProductInfoService;

@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {

	@Resource
	private ProductInfoMapper productInfoMapper;
	
	public ProductInfo searchById(Long id){
		return productInfoMapper.selectByPrimaryKey(id);
	}
	
	@Transactional
	public int insert(ProductInfo productInfo) {
		return productInfoMapper.insert(productInfo);
	}
	
	@Transactional
	public int update(ProductInfo productInfo) {
		return productInfoMapper.updateByPrimaryKey(productInfo);
	}
	
	@Transactional
	public int delete(Long id){
		return productInfoMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return productInfoMapper.updateForbiddenByPrimaryKey(id);
	}
	
	public List<ProductInfo> searchByParameters(ProductInfo productInfo) {
		return productInfoMapper.selectByParameters(productInfo);
	}

}