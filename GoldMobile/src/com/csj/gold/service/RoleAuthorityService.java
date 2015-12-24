package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.RoleAuthority;
import com.csj.gold.utils.page.Page;

public interface RoleAuthorityService {
	int add(RoleAuthority roleAuthority);

	int update(RoleAuthority roleAuthority);

	int delete(RoleAuthority roleAuthority);

	int forbidden(RoleAuthority roleAuthority);

	List<RoleAuthority> searchByParameters(Page page,RoleAuthority roleAuthority);

	RoleAuthority searchByPrimaryKey(RoleAuthority roleAuthority);
}
