package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.UserRole;

public interface UserRoleService {

	UserRole searchById(Long id);
	
	List<UserRole> searchByParameters(UserRole userRole);
	
	int insert(UserRole userRole);

	int update(UserRole userRole);
	
	int delete(Long id);
	
	int forbidden(Long id);
}