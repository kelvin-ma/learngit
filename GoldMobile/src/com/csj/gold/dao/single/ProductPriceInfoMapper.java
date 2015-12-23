package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.ProductPriceInfo;
import com.csj.gold.utils.page.Page;

public interface ProductPriceInfoMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(ProductPriceInfo record);

    int insertSelective(ProductPriceInfo record);

    ProductPriceInfo selectByPrimaryKey(Long id);
    
    List<ProductPriceInfo> selectByParameters(Page page);

    int updateByPrimaryKeySelective(ProductPriceInfo record);

    int updateByPrimaryKey(ProductPriceInfo record);
}