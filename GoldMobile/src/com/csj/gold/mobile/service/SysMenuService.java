package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysMenu;

public interface SysMenuService {

	SysMenu searchById(Long id);
	
	List<SysMenu> searchByParameters(SysMenu sysMenu);
	
	int insert(SysMenu sysMenu);

	int update(SysMenu sysMenu);
	
	int delete(Long id);
	
	int forbidden(Long id);
}