package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserAddress;
import com.csj.gold.utils.page.Page;

public interface MobileUserAddressService {
	
	List<UserAddress> searchByUserId(UserAddress userAddress);
	
	List<UserAddress> searchByParameters(Page page,UserAddress userAddress);
	
	int changeMainAddress(UserAddress userAddress);
	
	int deleteAddress(UserAddress userAddress);
	
	int forbiddenAddress(UserAddress userAddress);
	
	int addAddress(UserAddress userAddress);

	int updateAddress(UserAddress userAddress);
	
	UserAddress searchById(Long id);

}
