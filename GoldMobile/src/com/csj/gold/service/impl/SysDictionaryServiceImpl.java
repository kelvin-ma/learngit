package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysDictionaryMapper;
import com.csj.gold.model.SysDictionary;
import com.csj.gold.service.SysDictionaryService;
import com.csj.gold.utils.page.Page;

@Service("sysDictionaryService")
public class SysDictionaryServiceImpl implements SysDictionaryService{
	
	@Resource
	SysDictionaryMapper sysDictionaryMapper = null;

	@Override
	public int add(SysDictionary sysDictionary) {
		return sysDictionaryMapper.insertSelective(sysDictionary);
	}

	@Override
	public int update(SysDictionary sysDictionary) {
		return sysDictionaryMapper.updateByPrimaryKeySelective(sysDictionary);
	}

	@Override
	public int delete(SysDictionary sysDictionary) {
		return sysDictionaryMapper.deleteByPrimaryKey(sysDictionary.getId());
	}

	@Override
	public int forbidden(SysDictionary sysDictionary) {
		return sysDictionaryMapper.forbiddenByPrimaryKey(sysDictionary.getId());
	}

	@Override
	public List<SysDictionary> searchByParameters(Page page,SysDictionary sysDictionary) {
		page.setParameters(sysDictionary);
		List<SysDictionary> returnList = sysDictionaryMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysDictionary searchByPrimaryKey(SysDictionary sysDictionary) {
		return sysDictionaryMapper.selectByPrimaryKey(sysDictionary.getId());
	}

}
