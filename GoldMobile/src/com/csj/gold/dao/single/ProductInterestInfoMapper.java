package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.ProductInterestInfo;
import com.csj.gold.utils.page.Page;

public interface ProductInterestInfoMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(ProductInterestInfo record);

    int insertSelective(ProductInterestInfo record);

    ProductInterestInfo selectByPrimaryKey(Long id);
    
    List<ProductInterestInfo> selectByParameters(Page page);

    int updateByPrimaryKeySelective(ProductInterestInfo record);

    int updateByPrimaryKey(ProductInterestInfo record);
}