package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysAuthority;
import com.csj.gold.utils.page.Page;

public interface SysAuthorityService {
	int add(SysAuthority sysAuthority);

	int update(SysAuthority sysAuthority);

	int delete(SysAuthority sysAuthority);

	int forbidden(SysAuthority sysAuthority);

	List<SysAuthority> searchByParameters(Page page,SysAuthority sysAuthority);

	SysAuthority searchByPrimaryKey(SysAuthority sysAuthority);
}
