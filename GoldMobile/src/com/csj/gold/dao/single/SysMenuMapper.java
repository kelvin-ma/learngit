package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysMenu;
import com.csj.gold.utils.page.Page;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);
    
    List<SysMenu> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}