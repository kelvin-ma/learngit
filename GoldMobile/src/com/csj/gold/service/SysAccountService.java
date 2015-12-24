package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysAccount;
import com.csj.gold.utils.page.Page;

public interface SysAccountService {
	int add(SysAccount sysAccount);

	int update(SysAccount sysAccount);

	int delete(SysAccount sysAccount);

	int forbidden(SysAccount sysAccount);

	List<SysAccount> searchByParameters(Page page,SysAccount sysAccount);

	SysAccount searchByPrimaryKey(SysAccount sysAccount);
}
