package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysContact;
import com.csj.gold.utils.page.Page;

public interface SysContactService {
	int add(SysContact sysContact);

	int update(SysContact sysContact);

	int delete(SysContact sysContact);

	int forbidden(SysContact sysContact);

	List<SysContact> searchByParameters(Page page,SysContact sysContact);

	SysContact searchByPrimaryKey(SysContact sysContact);
}
