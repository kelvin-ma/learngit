package com.csj.gold.mobile.service;

import com.csj.gold.mobile.model.UserInfo;


public interface UserInfoService {
		 
		public UserInfo searchById(Integer id);
		
		//Page search(Page pager);
		
		public int insert(UserInfo user);
	 
		public int update(UserInfo user);
		
		public int delete(Integer id);
		
}

