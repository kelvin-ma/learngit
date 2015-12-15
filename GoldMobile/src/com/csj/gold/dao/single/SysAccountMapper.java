package com.csj.gold.dao.single;

import com.csj.gold.model.SysAccount;

public interface SysAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAccount record);

    int insertSelective(SysAccount record);

    SysAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAccount record);

    int updateByPrimaryKey(SysAccount record);
}