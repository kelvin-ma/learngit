package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysAuthorityMapper;
import com.csj.gold.mobile.model.SysAuthority;
import com.csj.gold.mobile.service.SysAuthorityService;

@Service("sysAuthorityService")
public class SysAuthorityServiceImpl implements SysAuthorityService {

	@Resource
	private SysAuthorityMapper sysAuthorityMapper;
	
	public SysAuthority searchById(Long id){
		return sysAuthorityMapper.selectByPrimaryKey(id);
	}
	
	public List<SysAuthority> searchByParameters(SysAuthority sysAuthority) {
		return sysAuthorityMapper.selectByParameters(sysAuthority);
	}
	
	@Transactional
	public int insert(SysAuthority sysAuthority) {
		return sysAuthorityMapper.insert(sysAuthority);
	}
	
	@Transactional
	public int update(SysAuthority sysAuthority) {
		return sysAuthorityMapper.updateByPrimaryKey(sysAuthority);
	}
	
	@Transactional
	public int delete(Long id){
		return sysAuthorityMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return sysAuthorityMapper.updateForbiddenByPrimaryKey(id);
	}
	
}