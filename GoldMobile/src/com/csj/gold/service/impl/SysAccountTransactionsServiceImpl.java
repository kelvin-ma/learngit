package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysAccountTransactionsMapper;
import com.csj.gold.model.SysAccountTransactions;
import com.csj.gold.service.SysAccountTransactionsService;
import com.csj.gold.utils.page.Page;

@Service("sysAccountTransactionsService")
public class SysAccountTransactionsServiceImpl implements SysAccountTransactionsService{
	
	@Resource
	SysAccountTransactionsMapper sysAccoutTransactionsMapper = null;

	@Override
	public int add(SysAccountTransactions sysAccountTransactions) {
		return sysAccoutTransactionsMapper.insertSelective(sysAccountTransactions);
	}

	@Override
	public int update(SysAccountTransactions sysAccountTransactions) {
		return sysAccoutTransactionsMapper.updateByPrimaryKeySelective(sysAccountTransactions);
	}

	@Override
	public int delete(SysAccountTransactions sysAccountTransactions) {
		return sysAccoutTransactionsMapper.deleteByPrimaryKey(sysAccountTransactions.getId());
	}

	@Override
	public int forbidden(SysAccountTransactions sysAccountTransactions) {
		return sysAccoutTransactionsMapper.forbiddenByPrimaryKey(sysAccountTransactions.getId());
	}

	@Override
	public List<SysAccountTransactions> searchByParameters(Page page,SysAccountTransactions sysAccountTransactions) {
		page.setParameters(sysAccountTransactions);
		List<SysAccountTransactions> returnList = sysAccoutTransactionsMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysAccountTransactions searchByPrimaryKey(SysAccountTransactions sysAccountTransactions) {
		return sysAccoutTransactionsMapper.selectByPrimaryKey(sysAccountTransactions.getId());
	}

}
