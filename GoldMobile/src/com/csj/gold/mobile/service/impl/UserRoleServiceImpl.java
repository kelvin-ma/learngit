package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.UserRoleMapper;
import com.csj.gold.mobile.model.UserRole;
import com.csj.gold.mobile.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleMapper userRoleMapper;
	
	public UserRole searchById(Long id){
		return userRoleMapper.selectByPrimaryKey(id);
	}
	
	public List<UserRole> searchByParameters(UserRole userRole) {
		return userRoleMapper.selectByParameters(userRole);
	}
	
	@Transactional
	public int insert(UserRole userRole) {
		return userRoleMapper.insert(userRole);
	}
	
	@Transactional
	public int update(UserRole userRole) {
		return userRoleMapper.updateByPrimaryKey(userRole);
	}
	
	@Transactional
	public int delete(Long id){
		return userRoleMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return userRoleMapper.updateForbiddenByPrimaryKey(id);
	}
	
}