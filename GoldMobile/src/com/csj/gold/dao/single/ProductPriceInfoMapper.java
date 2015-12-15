package com.csj.gold.dao.single;

import com.csj.gold.model.ProductPriceInfo;

public interface ProductPriceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPriceInfo record);

    int insertSelective(ProductPriceInfo record);

    ProductPriceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductPriceInfo record);

    int updateByPrimaryKey(ProductPriceInfo record);
}