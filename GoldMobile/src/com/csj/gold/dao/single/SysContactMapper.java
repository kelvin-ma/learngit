package com.csj.gold.dao.single;

import com.csj.gold.model.SysContact;

public interface SysContactMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysContact record);

    int insertSelective(SysContact record);

    SysContact selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysContact record);

    int updateByPrimaryKey(SysContact record);
}