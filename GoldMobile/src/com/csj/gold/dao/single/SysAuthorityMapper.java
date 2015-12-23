package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysAuthority;
import com.csj.gold.utils.page.Page;

public interface SysAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int forbiddenByPrimaryKey(Long id);
    
    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Long id);
    
    List<SysAuthority> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
}