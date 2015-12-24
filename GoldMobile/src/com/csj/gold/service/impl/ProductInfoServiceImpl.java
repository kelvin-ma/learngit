package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.ProductInfoMapper;
import com.csj.gold.model.ProductInfo;
import com.csj.gold.service.ProductInfoService;
import com.csj.gold.utils.page.Page;

@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService{
	
	@Resource
	ProductInfoMapper productInfoMapper = null;

	@Override
	public int add(ProductInfo productInfo) {
		return productInfoMapper.insertSelective(productInfo);
	}

	@Override
	public int update(ProductInfo productInfo) {
		return productInfoMapper.updateByPrimaryKeySelective(productInfo);
	}

	@Override
	public int delete(ProductInfo productInfo) {
		return productInfoMapper.deleteByPrimaryKey(productInfo.getId());
	}

	@Override
	public int forbidden(ProductInfo productInfo) {
		return productInfoMapper.forbiddenByPrimaryKey(productInfo.getId());
	}

	@Override
	public List<ProductInfo> searchByParameters(Page page,ProductInfo productInfo) {
		page.setParameters(productInfo);
		List<ProductInfo> returnList = productInfoMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public ProductInfo searchByPrimaryKey(ProductInfo productInfo) {
		return productInfoMapper.selectByPrimaryKey(productInfo.getId());
	}

}
