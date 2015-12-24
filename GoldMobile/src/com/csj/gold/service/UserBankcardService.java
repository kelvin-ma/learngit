package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserBankcard;
import com.csj.gold.utils.page.Page;

public interface UserBankcardService {
	int add(UserBankcard userBankcard);

	int update(UserBankcard userBankcard);

	int delete(UserBankcard userBankcard);

	int forbidden(UserBankcard userBankcard);

	List<UserBankcard> searchByParameters(Page page,UserBankcard userBankcard);

	UserBankcard searchByPrimaryKey(UserBankcard userBankcard);
}
