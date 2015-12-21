package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysDictionary;

public interface SysDictionaryMapper {
    int deleteByPrimaryKey(Integer id);
    
    int forbiddenByPrimaryKey(Integer id);
    
    int insert(SysDictionary sysDictionary);

    int insertSelective(SysDictionary sysDictionary);

    SysDictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictionary sysDictionary);

    int updateByPrimaryKey(SysDictionary sysDictionary);
    
    List<SysDictionary> selectByParameters(SysDictionary sysdictionary);

}