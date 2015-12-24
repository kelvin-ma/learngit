package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysMenu;
import com.csj.gold.utils.page.Page;

public interface SysMenuService {
	int add(SysMenu sysMenu);

	int update(SysMenu sysMenu);

	int delete(SysMenu sysMenu);

	int forbidden(SysMenu sysMenu);

	List<SysMenu> searchByParameters(Page page,SysMenu sysMenu);

	SysMenu searchByPrimaryKey(SysMenu sysMenu);
}
