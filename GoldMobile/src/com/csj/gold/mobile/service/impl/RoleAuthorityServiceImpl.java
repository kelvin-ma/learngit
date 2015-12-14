package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.RoleAuthorityMapper;
import com.csj.gold.mobile.model.RoleAuthority;
import com.csj.gold.mobile.service.RoleAuthorityService;

@Service("roleAuthorityService")
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

	@Resource
	private RoleAuthorityMapper roleAuthorityMapper;
	
	public RoleAuthority searchById(Long id){
		return roleAuthorityMapper.selectByPrimaryKey(id);
	}
	
	public List<RoleAuthority> searchByParameters(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.selectByParameters(roleAuthority);
	}
	
	@Transactional
	public int insert(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.insert(roleAuthority);
	}
	
	@Transactional
	public int update(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.updateByPrimaryKey(roleAuthority);
	}
	
	@Transactional
	public int delete(Long id){
		return roleAuthorityMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return roleAuthorityMapper.updateForbiddenByPrimaryKey(id);
	}
	
}