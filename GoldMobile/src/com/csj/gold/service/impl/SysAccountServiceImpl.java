package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysAccountMapper;
import com.csj.gold.model.SysAccount;
import com.csj.gold.service.SysAccountService;
import com.csj.gold.utils.page.Page;

@Service("sysAccountService")
public class SysAccountServiceImpl implements SysAccountService{
	
	@Resource
	SysAccountMapper sysAccountMapper = null;

	@Override
	public int add(SysAccount sysAccount) {
		return sysAccountMapper.insertSelective(sysAccount);
	}

	@Override
	public int update(SysAccount sysAccount) {
		return sysAccountMapper.updateByPrimaryKeySelective(sysAccount);
	}

	@Override
	public int delete(SysAccount sysAccount) {
		return sysAccountMapper.deleteByPrimaryKey(sysAccount.getId());
	}

	@Override
	public int forbidden(SysAccount sysAccount) {
		return sysAccountMapper.forbiddenByPrimaryKey(sysAccount.getId());
	}

	@Override
	public List<SysAccount> searchByParameters(Page page,SysAccount sysAccount) {
		page.setParameters(sysAccount);
		List<SysAccount> returnList = sysAccountMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysAccount searchByPrimaryKey(SysAccount sysAccount) {
		return sysAccountMapper.selectByPrimaryKey(sysAccount.getId());
	}

}
