package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserLogin;
import com.csj.gold.utils.page.Page;

public interface UserLoginService {
	int add(UserLogin userLogin);

	int update(UserLogin userLogin);

	int delete(UserLogin userLogin);

	int forbidden(UserLogin userLogin);

	List<UserLogin> searchByParameters(Page page,UserLogin userLogin);

	UserLogin searchByPrimaryKey(UserLogin userLogin);
}
