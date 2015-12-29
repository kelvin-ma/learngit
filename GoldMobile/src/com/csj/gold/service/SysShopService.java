package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysShop;
import com.csj.gold.utils.page.Page;

public interface SysShopService {
	int add(SysShop sysShop);

	int update(SysShop sysShop);

	int delete(SysShop sysShop);

	int forbidden(SysShop sysShop);

	List<SysShop> searchByParameters(Page page,SysShop sysShop);

	SysShop searchByPrimaryKey(SysShop sysShop);
}