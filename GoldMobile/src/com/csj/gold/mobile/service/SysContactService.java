package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.SysContact;

public interface SysContactService {

	SysContact searchById(Long id);
	
	List<SysContact> searchByParameters(SysContact sysContact);
	
	int insert(SysContact sysContact);

	int update(SysContact sysContact);
	
	int delete(Long id);
	
	int forbidden(Long id);
}