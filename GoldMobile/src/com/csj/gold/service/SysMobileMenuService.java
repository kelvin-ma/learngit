package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysMobileMenu;
import com.csj.gold.utils.page.Page;

public interface SysMobileMenuService {
	int add(SysMobileMenu sysMobileMenu);

	int update(SysMobileMenu sysMobileMenu);

	int delete(SysMobileMenu sysMobileMenu);

	int forbidden(SysMobileMenu sysMobileMenu);

	List<SysMobileMenu> searchByParameters(Page page,SysMobileMenu sysMobileMenu);

	SysMobileMenu searchByPrimaryKey(SysMobileMenu sysMobileMenu);
}
