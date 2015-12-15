package com.csj.gold.mobile.dao;

import java.util.List;

import com.csj.gold.mobile.model.ProductTransactionsRule;

public interface ProductTransactionsRuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_transactions_rule
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_transactions_rule
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insert(ProductTransactionsRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_transactions_rule
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insertSelective(ProductTransactionsRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_transactions_rule
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    ProductTransactionsRule selectByPrimaryKey(Long id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_type
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    List<ProductTransactionsRule> selectByParameters(ProductTransactionsRule productTransactionsRule);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_transactions_rule
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKeySelective(ProductTransactionsRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_transactions_rule
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKey(ProductTransactionsRule record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateForbiddenByPrimaryKey(Long id);
}