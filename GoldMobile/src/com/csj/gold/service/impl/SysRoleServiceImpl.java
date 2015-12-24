package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysRoleMapper;
import com.csj.gold.model.SysRole;
import com.csj.gold.service.SysRoleService;
import com.csj.gold.utils.page.Page;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{
	
	@Resource
	SysRoleMapper sysRoleMapper = null;

	@Override
	public int add(SysRole sysRole) {
		return sysRoleMapper.insertSelective(sysRole);
	}

	@Override
	public int update(SysRole sysRole) {
		return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
	}

	@Override
	public int delete(SysRole sysRole) {
		return sysRoleMapper.deleteByPrimaryKey(sysRole.getId());
	}

	@Override
	public int forbidden(SysRole sysRole) {
		return sysRoleMapper.forbiddenByPrimaryKey(sysRole.getId());
	}

	@Override
	public List<SysRole> searchByParameters(Page page,SysRole sysRole) {
		page.setParameters(sysRole);
		List<SysRole> returnList = sysRoleMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysRole searchByPrimaryKey(SysRole sysRole) {
		return sysRoleMapper.selectByPrimaryKey(sysRole.getId());
	}

}
