package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserRoleMapper;
import com.csj.gold.model.UserRole;
import com.csj.gold.service.UserRoleService;
import com.csj.gold.utils.page.Page;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{
	
	@Resource
	UserRoleMapper userRoleMapper = null;

	@Override
	public int add(UserRole userRole) {
		return userRoleMapper.insertSelective(userRole);
	}

	@Override
	public int update(UserRole userRole) {
		return userRoleMapper.updateByPrimaryKeySelective(userRole);
	}

	@Override
	public int delete(UserRole userRole) {
		return userRoleMapper.deleteByPrimaryKey(userRole.getId());
	}

	@Override
	public int forbidden(UserRole userRole) {
		return userRoleMapper.forbiddenByPrimaryKey(userRole.getId());
	}

	@Override
	public List<UserRole> searchByParameters(Page page,UserRole userRole) {
		page.setParameters(userRole);
		List<UserRole> returnList = userRoleMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public UserRole searchByPrimaryKey(UserRole userRole) {
		return userRoleMapper.selectByPrimaryKey(userRole.getId());
	}

}
