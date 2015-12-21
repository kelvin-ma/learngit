package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysDictionaryType;

public interface SysDictionaryTypeService {
	int add(SysDictionaryType sysDictionaryType);

	int update(SysDictionaryType sysDictionaryType);

	int delete(SysDictionaryType sysDictionaryType);

	int forbidden(SysDictionaryType sysDictionaryType);

	List<SysDictionaryType> searchByParameters(SysDictionaryType sysDictionaryType);

	SysDictionaryType searchByPrimaryKey(SysDictionaryType sysDictionaryType);
}