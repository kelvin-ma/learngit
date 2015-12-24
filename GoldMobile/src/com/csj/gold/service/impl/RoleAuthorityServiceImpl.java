package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.RoleAuthorityMapper;
import com.csj.gold.model.RoleAuthority;
import com.csj.gold.service.RoleAuthorityService;
import com.csj.gold.utils.page.Page;

@Service("roleAuthorityService")
public class RoleAuthorityServiceImpl implements RoleAuthorityService{
	
	@Resource
	RoleAuthorityMapper roleAuthorityMapper = null;

	@Override
	public int add(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.insertSelective(roleAuthority);
	}

	@Override
	public int update(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.updateByPrimaryKeySelective(roleAuthority);
	}

	@Override
	public int delete(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.deleteByPrimaryKey(roleAuthority.getId());
	}

	@Override
	public int forbidden(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.forbiddenByPrimaryKey(roleAuthority.getId());
	}

	@Override
	public List<RoleAuthority> searchByParameters(Page page,RoleAuthority roleAuthority) {
		page.setParameters(roleAuthority);
		List<RoleAuthority> returnList = roleAuthorityMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public RoleAuthority searchByPrimaryKey(RoleAuthority roleAuthority) {
		return roleAuthorityMapper.selectByPrimaryKey(roleAuthority.getId());
	}

}
