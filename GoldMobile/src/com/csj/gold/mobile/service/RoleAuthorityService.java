package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.RoleAuthority;

public interface RoleAuthorityService {

	RoleAuthority searchById(Long id);
	
	List<RoleAuthority> searchByParameters(RoleAuthority roleAuthority);
	
	int insert(RoleAuthority roleAuthority);

	int update(RoleAuthority roleAuthority);
	
	int delete(Long id);
	
	int forbidden(Long id);
}