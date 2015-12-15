package com.csj.gold.dao.single;

import com.csj.gold.model.ProductTransactionsRule;

public interface ProductTransactionsRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductTransactionsRule record);

    int insertSelective(ProductTransactionsRule record);

    ProductTransactionsRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductTransactionsRule record);

    int updateByPrimaryKey(ProductTransactionsRule record);
}