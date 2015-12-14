package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysDictionary;

public interface SysDictionaryService {

	SysDictionary searchById(Integer id);
	
	List<SysDictionary> searchByParameters(SysDictionary sysDictionary);
	
	int insert(SysDictionary sysDictionary);

	int update(SysDictionary sysDictionary);
	
	int delete(Integer id);
	
	int forbidden(Integer id);
}