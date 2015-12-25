package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.GoldPrice;
import com.csj.gold.utils.page.Page;

public interface GoldPriceMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(GoldPrice record);

    int insertSelective(GoldPrice record);

    GoldPrice selectByPrimaryKey(Long id);
    
    List<GoldPrice> selectByParameters(Page page);

    int updateByPrimaryKeySelective(GoldPrice record);

    int updateByPrimaryKey(GoldPrice record);
}