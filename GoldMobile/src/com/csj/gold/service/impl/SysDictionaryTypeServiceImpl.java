package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysDictionaryTypeMapper;
import com.csj.gold.model.SysDictionaryType;
import com.csj.gold.service.SysDictionaryTypeService;

@Service("sysDictionaryTypeService")
public class SysDictionaryTypeServiceImpl implements SysDictionaryTypeService{
	
	@Resource
	SysDictionaryTypeMapper sysDictionaryTypeMapper = null;

	@Override
	public int add(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.insertSelective(sysDictionaryType);
	}

	@Override
	public int update(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.updateByPrimaryKeySelective(sysDictionaryType);
	}

	@Override
	public int delete(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.deleteByPrimaryKey(sysDictionaryType.getId());
	}

	@Override
	public int forbidden(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.forbiddenByPrimaryKey(sysDictionaryType.getId());
	}

	@Override
	public List<SysDictionaryType> searchByParameters(SysDictionaryType sysDictionaryType) {
		List<SysDictionaryType> returnList = sysDictionaryTypeMapper.selectByParameters(sysDictionaryType);
		return returnList;
	}

	@Override
	public SysDictionaryType searchByPrimaryKey(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.selectByPrimaryKey(sysDictionaryType.getId());
	}

}
