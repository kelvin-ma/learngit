package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysDictionaryTypeMapper;
import com.csj.gold.mobile.model.SysDictionaryType;
import com.csj.gold.mobile.service.SysDictionaryTypeService;

@Service("sysDictionaryTypeService")
public class SysDictionaryTypeServiceImpl implements SysDictionaryTypeService {

	@Resource
	private SysDictionaryTypeMapper sysDictionaryTypeMapper;
	
	public SysDictionaryType searchById(Integer id){
		return sysDictionaryTypeMapper.selectByPrimaryKey(id);
	}
	
	public List<SysDictionaryType> searchByParameters(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.selectByParameters(sysDictionaryType);
	}
	
	@Transactional
	public int insert(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.insert(sysDictionaryType);
	}
	
	@Transactional
	public int update(SysDictionaryType sysDictionaryType) {
		return sysDictionaryTypeMapper.updateByPrimaryKey(sysDictionaryType);
	}
	
	@Transactional
	public int delete(Integer id){
		return sysDictionaryTypeMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Integer id){
		return sysDictionaryTypeMapper.updateForbiddenByPrimaryKey(id);
	}
	
}