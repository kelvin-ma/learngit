package com.csj.gold.dao.single;

import com.csj.gold.model.SysAuthority;

public interface SysAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
}