package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysDictionaryType;

public interface SysDictionaryTypeService {

	SysDictionaryType searchById(Integer id);
	
	List<SysDictionaryType> searchByParameters(SysDictionaryType sysDictionaryType);
	
	int insert(SysDictionaryType sysDictionaryType);

	int update(SysDictionaryType sysDictionaryType);
	
	int delete(Integer id);
	
	int forbidden(Integer id);
}