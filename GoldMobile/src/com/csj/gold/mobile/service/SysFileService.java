package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysFile;

public interface SysFileService {

	SysFile searchById(Long id);
	
	List<SysFile> searchByParameters(SysFile sysFile);
	
	int insert(SysFile sysFile);

	int update(SysFile sysFile);
	
	int delete(Long id);
	
	int forbidden(Long id);
}