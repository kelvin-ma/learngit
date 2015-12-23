package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysDictionaryType;
import com.csj.gold.utils.page.Page;

public interface SysDictionaryTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictionaryType sysDictionaryType);

    int insertSelective(SysDictionaryType sysDictionaryType);

    SysDictionaryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictionaryType sysDictionaryType);

    int updateByPrimaryKey(SysDictionaryType sysDictionaryType);

	int forbiddenByPrimaryKey(Integer id);
	
	List<SysDictionaryType> selectByParameters(Page page);
}