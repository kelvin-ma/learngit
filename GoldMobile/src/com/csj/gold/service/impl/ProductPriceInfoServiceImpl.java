package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.ProductPriceInfoMapper;
import com.csj.gold.model.ProductPriceInfo;
import com.csj.gold.service.ProductPriceInfoService;
import com.csj.gold.utils.page.Page;

@Service("productPriceInfoService")
public class ProductPriceInfoServiceImpl implements ProductPriceInfoService{
	
	@Resource
	ProductPriceInfoMapper productPriceInfoMapper = null;

	@Override
	public int add(ProductPriceInfo productPriceInfo) {
		return productPriceInfoMapper.insertSelective(productPriceInfo);
	}

	@Override
	public int update(ProductPriceInfo productPriceInfo) {
		return productPriceInfoMapper.updateByPrimaryKeySelective(productPriceInfo);
	}

	@Override
	public int delete(ProductPriceInfo productPriceInfo) {
		return productPriceInfoMapper.deleteByPrimaryKey(productPriceInfo.getId());
	}

	@Override
	public int forbidden(ProductPriceInfo productPriceInfo) {
		return productPriceInfoMapper.forbiddenByPrimaryKey(productPriceInfo.getId());
	}

	@Override
	public List<ProductPriceInfo> searchByParameters(Page page,ProductPriceInfo productPriceInfo) {
		page.setParameters(productPriceInfo);
		List<ProductPriceInfo> returnList = productPriceInfoMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public ProductPriceInfo searchByPrimaryKey(ProductPriceInfo productPriceInfo) {
		return productPriceInfoMapper.selectByPrimaryKey(productPriceInfo.getId());
	}

}
