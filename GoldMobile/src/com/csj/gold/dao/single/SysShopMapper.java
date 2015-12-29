package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysShop;
import com.csj.gold.utils.page.Page;

public interface SysShopMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysShop sysShop);

    int insertSelective(SysShop sysShop);

    SysShop selectByPrimaryKey(Long id);
    
    List<SysShop> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysShop sysShop);

    int updateByPrimaryKey(SysShop sysShop);
}