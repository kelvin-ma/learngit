package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysAccountTransactions;

public interface SysAccountTransactionsService {
	int add(SysAccountTransactions sysAccountTransactions);

	int update(SysAccountTransactions sysAccountTransactions);

	int delete(SysAccountTransactions sysAccountTransactions);

	int forbidden(SysAccountTransactions sysAccountTransactions);

	List<SysAccountTransactions> searchByParameters(SysAccountTransactions sysAccountTransactions);

	SysAccountTransactions searchByPrimaryKey(SysAccountTransactions sysAccountTransactions);
}
