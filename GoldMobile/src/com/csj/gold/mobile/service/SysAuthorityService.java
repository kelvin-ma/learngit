package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysAuthority;

public interface SysAuthorityService {

	SysAuthority searchById(Long id);
	
	List<SysAuthority> searchByParameters(SysAuthority sysAuthority);
	
	int insert(SysAuthority sysAuthority);

	int update(SysAuthority sysAuthority);
	
	int delete(Long id);
	
	int forbidden(Long id);
}