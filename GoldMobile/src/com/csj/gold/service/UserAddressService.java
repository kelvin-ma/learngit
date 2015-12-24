package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserAddress;
import com.csj.gold.utils.page.Page;

public interface UserAddressService {
	int add(UserAddress userAddress);

	int update(UserAddress userAddress);

	int delete(UserAddress userAddress);

	int forbidden(UserAddress userAddress);

	List<UserAddress> searchByParameters(Page page,UserAddress userAddress);

	UserAddress searchByPrimaryKey(UserAddress userAddress);
}
