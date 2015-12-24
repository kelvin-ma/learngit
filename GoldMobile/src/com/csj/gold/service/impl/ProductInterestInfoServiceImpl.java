package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.ProductInterestInfoMapper;
import com.csj.gold.model.ProductInterestInfo;
import com.csj.gold.service.ProductInterestInfoService;
import com.csj.gold.utils.page.Page;

@Service("productInterestInfoService")
public class ProductInterestInfoServiceImpl implements ProductInterestInfoService{
	
	@Resource
	ProductInterestInfoMapper productInterestInfoMapper = null;

	@Override
	public int add(ProductInterestInfo productPriceInfo) {
		return productInterestInfoMapper.insertSelective(productPriceInfo);
	}

	@Override
	public int update(ProductInterestInfo productPriceInfo) {
		return productInterestInfoMapper.updateByPrimaryKeySelective(productPriceInfo);
	}

	@Override
	public int delete(ProductInterestInfo productPriceInfo) {
		return productInterestInfoMapper.deleteByPrimaryKey(productPriceInfo.getId());
	}

	@Override
	public int forbidden(ProductInterestInfo productPriceInfo) {
		return productInterestInfoMapper.forbiddenByPrimaryKey(productPriceInfo.getId());
	}

	@Override
	public List<ProductInterestInfo> searchByParameters(Page page,ProductInterestInfo productPriceInfo) {
		page.setParameters(productPriceInfo);
		List<ProductInterestInfo> returnList = productInterestInfoMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public ProductInterestInfo searchByPrimaryKey(ProductInterestInfo productPriceInfo) {
		return productInterestInfoMapper.selectByPrimaryKey(productPriceInfo.getId());
	}

}
