package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserAddress;

public interface MobileUserAddressService {
	
	List<UserAddress> searchByUserId(UserAddress userAddress);
	
	int changeMainAddress(UserAddress userAddress);
	
	int deleteAddress(UserAddress userAddress);
	
	int addAddress(UserAddress userAddress);

	int updateAddress(UserAddress userAddress);
}
