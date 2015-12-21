package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysFile;

public interface SysFileService {
	int add(SysFile sysFile);

	int update(SysFile sysFile);

	int delete(SysFile sysFile);

	int forbidden(SysFile sysFile);

	List<SysFile> searchByParameters(SysFile sysFile);

	SysFile searchByPrimaryKey(SysFile sysFile);
}
