package com.csj.gold.mobile.service;

import com.csj.gold.mobile.model.UserInfo;


public interface UserInfoService {
		 
		UserInfo searchById(Integer id);
		
		//Page search(Page pager);
		
		int insert(UserInfo user);
	 
		int update(UserInfo user);
		
		int delete(Integer id);
		
}

