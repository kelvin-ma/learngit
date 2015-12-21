package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysDictionary;

public interface SysDictionaryService {
	int add(SysDictionary sysDictionary);

	int update(SysDictionary sysDictionary);

	int delete(SysDictionary sysDictionary);

	int forbidden(SysDictionary sysDictionary);

	List<SysDictionary> searchByParameters(SysDictionary sysDictionary);

	SysDictionary searchByPrimaryKey(SysDictionary sysDictionary);
}