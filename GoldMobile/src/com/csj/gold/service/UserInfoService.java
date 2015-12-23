package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserInfo;
import com.csj.gold.utils.page.Page;

public interface UserInfoService {
	int add(UserInfo userInfo);

	int update(UserInfo userInfo);

	int delete(UserInfo userInfo);

	int forbidden(UserInfo userInfo);

	List<UserInfo> searchByParameters(Page page,UserInfo userInfo);

	UserInfo searchByPrimaryKey(UserInfo userInfo);
}
