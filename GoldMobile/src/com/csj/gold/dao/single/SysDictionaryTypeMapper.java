package com.csj.gold.dao.single;

import com.csj.gold.model.SysDictionaryType;

public interface SysDictionaryTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictionaryType record);

    int insertSelective(SysDictionaryType record);

    SysDictionaryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictionaryType record);

    int updateByPrimaryKey(SysDictionaryType record);
}