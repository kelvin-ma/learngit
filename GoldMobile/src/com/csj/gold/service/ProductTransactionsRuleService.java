package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.ProductTransactionsRule;
import com.csj.gold.utils.page.Page;

public interface ProductTransactionsRuleService {
	int add(ProductTransactionsRule productTransactionsRule);

	int update(ProductTransactionsRule productTransactionsRule);

	int delete(ProductTransactionsRule productTransactionsRule);

	int forbidden(ProductTransactionsRule productTransactionsRule);

	List<ProductTransactionsRule> searchByParameters(Page page,ProductTransactionsRule productTransactionsRule);

	ProductTransactionsRule searchByPrimaryKey(ProductTransactionsRule productTransactionsRule);
}
