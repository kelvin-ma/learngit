package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysRole;
import com.csj.gold.utils.page.Page;

public interface SysRoleService {
	int add(SysRole sysRole);

	int update(SysRole sysRole);

	int delete(SysRole sysRole);

	int forbidden(SysRole sysRole);

	List<SysRole> searchByParameters(Page page,SysRole sysRole);

	SysRole searchByPrimaryKey(SysRole sysRole);
}
