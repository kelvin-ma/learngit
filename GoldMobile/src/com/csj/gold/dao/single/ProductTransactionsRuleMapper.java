package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.ProductTransactionsRule;
import com.csj.gold.utils.page.Page;

public interface ProductTransactionsRuleMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(ProductTransactionsRule record);

    int insertSelective(ProductTransactionsRule record);

    ProductTransactionsRule selectByPrimaryKey(Long id);
    
    List<ProductTransactionsRule> selectByParameters(Page page);

    int updateByPrimaryKeySelective(ProductTransactionsRule record);

    int updateByPrimaryKey(ProductTransactionsRule record);
}