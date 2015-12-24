package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserRole;
import com.csj.gold.utils.page.Page;

public interface UserRoleService {
	int add(UserRole userRole);

	int update(UserRole userRole);

	int delete(UserRole userRole);

	int forbidden(UserRole userRole);

	List<UserRole> searchByParameters(Page page,UserRole userRole);

	UserRole searchByPrimaryKey(UserRole userRole);
}
