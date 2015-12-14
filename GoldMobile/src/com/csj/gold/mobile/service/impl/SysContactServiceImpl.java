package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysContactMapper;
import com.csj.gold.mobile.model.SysContact;
import com.csj.gold.mobile.service.SysContactService;

@Service("sysContactService")
public class SysContactServiceImpl implements SysContactService {

	@Resource
	private SysContactMapper sysContactMapper;
	
	public SysContact searchById(Long id){
		return sysContactMapper.selectByPrimaryKey(id);
	}
	
	public List<SysContact> searchByParameters(SysContact sysContact) {
		return sysContactMapper.selectByParameters(sysContact);
	}
	
	@Transactional
	public int insert(SysContact sysContact) {
		return sysContactMapper.insert(sysContact);
	}
	
	@Transactional
	public int update(SysContact sysContact) {
		return sysContactMapper.updateByPrimaryKey(sysContact);
	}
	
	@Transactional
	public int delete(Long id){
		return sysContactMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return sysContactMapper.updateForbiddenByPrimaryKey(id);
	}
	
}