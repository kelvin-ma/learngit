package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysRole;
import com.csj.gold.utils.page.Page;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);
    
    List<SysRole> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}