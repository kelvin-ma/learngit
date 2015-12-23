package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysDictionary;
import com.csj.gold.utils.page.Page;

public interface SysDictionaryService {
	int add(SysDictionary sysDictionary);

	int update(SysDictionary sysDictionary);

	int delete(SysDictionary sysDictionary);

	int forbidden(SysDictionary sysDictionary);

	List<SysDictionary> searchByParameters(Page page,SysDictionary sysDictionary);

	SysDictionary searchByPrimaryKey(SysDictionary sysDictionary);
}