package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.ProductTransactionsRuleMapper;
import com.csj.gold.model.ProductTransactionsRule;
import com.csj.gold.service.ProductTransactionsRuleService;
import com.csj.gold.utils.page.Page;

@Service("productTransactionsRuleService")
public class ProductTransactionsRuleServiceImpl implements ProductTransactionsRuleService{
	
	@Resource
	ProductTransactionsRuleMapper productTransactionsRuleMapper = null;

	@Override
	public int add(ProductTransactionsRule productTransactionsRule) {
		return productTransactionsRuleMapper.insertSelective(productTransactionsRule);
	}

	@Override
	public int update(ProductTransactionsRule productTransactionsRule) {
		return productTransactionsRuleMapper.updateByPrimaryKeySelective(productTransactionsRule);
	}

	@Override
	public int delete(ProductTransactionsRule productTransactionsRule) {
		return productTransactionsRuleMapper.deleteByPrimaryKey(productTransactionsRule.getId());
	}

	@Override
	public int forbidden(ProductTransactionsRule productTransactionsRule) {
		return productTransactionsRuleMapper.forbiddenByPrimaryKey(productTransactionsRule.getId());
	}

	@Override
	public List<ProductTransactionsRule> searchByParameters(Page page,ProductTransactionsRule productTransactionsRule) {
		page.setParameters(productTransactionsRule);
		List<ProductTransactionsRule> returnList = productTransactionsRuleMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public ProductTransactionsRule searchByPrimaryKey(ProductTransactionsRule productTransactionsRule) {
		return productTransactionsRuleMapper.selectByPrimaryKey(productTransactionsRule.getId());
	}

}
