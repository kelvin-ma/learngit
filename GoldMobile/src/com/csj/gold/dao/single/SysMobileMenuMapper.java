package com.csj.gold.dao.single;

import com.csj.gold.model.SysMobileMenu;

public interface SysMobileMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMobileMenu record);

    int insertSelective(SysMobileMenu record);

    SysMobileMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMobileMenu record);

    int updateByPrimaryKey(SysMobileMenu record);
}