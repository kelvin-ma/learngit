package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysFile;
import com.csj.gold.utils.page.Page;

public interface SysFileService {
	int add(SysFile sysFile);

	int update(SysFile sysFile);

	int delete(SysFile sysFile);

	int forbidden(SysFile sysFile);

	List<SysFile> searchByParameters(Page page,SysFile sysFile);

	SysFile searchByPrimaryKey(SysFile sysFile);
}
