package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysDictionaryMapper;
import com.csj.gold.mobile.model.SysDictionary;
import com.csj.gold.mobile.service.SysDictionaryService;

@Service("sysDictionaryService")
public class SysDictionaryServiceImpl implements SysDictionaryService {

	@Resource
	private SysDictionaryMapper sysDictionaryMapper;
	
	public SysDictionary searchById(Integer id){
		return sysDictionaryMapper.selectByPrimaryKey(id);
	}
	
	public List<SysDictionary> searchByParameters(SysDictionary sysDictionary) {
		return sysDictionaryMapper.selectByParameters(sysDictionary);
	}
	
	@Transactional
	public int insert(SysDictionary sysDictionary) {
		return sysDictionaryMapper.insert(sysDictionary);
	}
	
	@Transactional
	public int update(SysDictionary sysDictionary) {
		return sysDictionaryMapper.updateByPrimaryKey(sysDictionary);
	}
	
	@Transactional
	public int delete(Integer id){
		return sysDictionaryMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Integer id){
		return sysDictionaryMapper.updateForbiddenByPrimaryKey(id);
	}
	
}