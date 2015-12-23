package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysMobileMenu;
import com.csj.gold.utils.page.Page;

public interface SysMobileMenuMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysMobileMenu record);

    int insertSelective(SysMobileMenu record);

    SysMobileMenu selectByPrimaryKey(Long id);
    
    List<SysMobileMenu> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysMobileMenu record);

    int updateByPrimaryKey(SysMobileMenu record);
}