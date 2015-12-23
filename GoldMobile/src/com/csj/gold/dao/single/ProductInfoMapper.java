package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.ProductInfo;
import com.csj.gold.utils.page.Page;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Long id);
    
    List<ProductInfo> selectByParameters(Page page);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}