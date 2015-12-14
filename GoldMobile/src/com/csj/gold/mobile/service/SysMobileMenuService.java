package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysMobileMenu;

public interface SysMobileMenuService {

	SysMobileMenu searchById(Long id);
	
	List<SysMobileMenu> searchByParameters(SysMobileMenu sysMobileMenu);
	
	int insert(SysMobileMenu sysMobileMenu);

	int update(SysMobileMenu sysMobileMenu);
	
	int delete(Long id);
	
	int forbidden(Long id);
}