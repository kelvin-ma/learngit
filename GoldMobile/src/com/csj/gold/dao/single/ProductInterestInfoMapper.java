package com.csj.gold.dao.single;

import com.csj.gold.model.ProductInterestInfo;

public interface ProductInterestInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductInterestInfo record);

    int insertSelective(ProductInterestInfo record);

    ProductInterestInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductInterestInfo record);

    int updateByPrimaryKey(ProductInterestInfo record);
}