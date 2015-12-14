package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysRole;

public interface SysRoleService {

	SysRole searchById(Long id);
	
	List<SysRole> searchByParameters(SysRole sysRole);
	
	int insert(SysRole sysRole);

	int update(SysRole sysRole);
	
	int delete(Long id);
	
	int forbidden(Long id);
}