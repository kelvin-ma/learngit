package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysAuthorityMapper;
import com.csj.gold.model.SysAuthority;
import com.csj.gold.service.SysAuthorityService;
import com.csj.gold.utils.page.Page;

@Service("sysAuthorityService")
public class SysAuthorityServiceImpl implements SysAuthorityService{
	
	@Resource
	SysAuthorityMapper sysAuthorityMapper = null;

	@Override
	public int add(SysAuthority sysAuthority) {
		return sysAuthorityMapper.insertSelective(sysAuthority);
	}

	@Override
	public int update(SysAuthority sysAuthority) {
		return sysAuthorityMapper.updateByPrimaryKeySelective(sysAuthority);
	}

	@Override
	public int delete(SysAuthority sysAuthority) {
		return sysAuthorityMapper.deleteByPrimaryKey(sysAuthority.getId());
	}

	@Override
	public int forbidden(SysAuthority sysAuthority) {
		return sysAuthorityMapper.forbiddenByPrimaryKey(sysAuthority.getId());
	}

	@Override
	public List<SysAuthority> searchByParameters(Page page,SysAuthority sysAuthority) {
		page.setParameters(sysAuthority);
		List<SysAuthority> returnList = sysAuthorityMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysAuthority searchByPrimaryKey(SysAuthority sysAuthority) {
		return sysAuthorityMapper.selectByPrimaryKey(sysAuthority.getId());
	}

}
