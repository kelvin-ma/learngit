package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysRoleMapper;
import com.csj.gold.mobile.model.SysRole;
import com.csj.gold.mobile.service.SysRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleMapper sysRoleMapper;
	
	public SysRole searchById(Long id){
		return sysRoleMapper.selectByPrimaryKey(id);
	}
	
	public List<SysRole> searchByParameters(SysRole sysRole) {
		return sysRoleMapper.selectByParameters(sysRole);
	}
	
	@Transactional
	public int insert(SysRole sysRole) {
		return sysRoleMapper.insert(sysRole);
	}
	
	@Transactional
	public int update(SysRole sysRole) {
		return sysRoleMapper.updateByPrimaryKey(sysRole);
	}
	
	@Transactional
	public int delete(Long id){
		return sysRoleMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return sysRoleMapper.updateForbiddenByPrimaryKey(id);
	}
	
}