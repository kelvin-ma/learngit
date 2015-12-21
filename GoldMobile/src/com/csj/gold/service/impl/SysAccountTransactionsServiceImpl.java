package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysAccoutTransactionsMapper;
import com.csj.gold.model.SysAccountTransactions;
import com.csj.gold.service.SysAccountTransactionsService;

@Service("sysAccountTransactionsService")
public class SysAccountTransactionsServiceImpl implements SysAccountTransactionsService{
	
	@Resource
	SysAccoutTransactionsMapper sysAccoutTransactionsMapper = null;

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
	public List<SysAccountTransactions> searchByParameters(SysAccountTransactions sysAccountTransactions) {
		List<SysAccountTransactions> returnList = sysAccoutTransactionsMapper.selectByParameters(sysAccountTransactions);
		return returnList;
	}

	@Override
	public SysAccountTransactions searchByPrimaryKey(SysAccountTransactions sysAccountTransactions) {
		return sysAccoutTransactionsMapper.selectByPrimaryKey(sysAccountTransactions.getId());
	}

}
