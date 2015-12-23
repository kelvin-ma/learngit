package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysDictionaryType;
import com.csj.gold.utils.page.Page;

public interface SysDictionaryTypeService {
	int add(SysDictionaryType sysDictionaryType);

	int update(SysDictionaryType sysDictionaryType);

	int delete(SysDictionaryType sysDictionaryType);

	int forbidden(SysDictionaryType sysDictionaryType);

	List<SysDictionaryType> searchByParameters(Page page,SysDictionaryType sysDictionaryType);

	SysDictionaryType searchByPrimaryKey(SysDictionaryType sysDictionaryType);
}