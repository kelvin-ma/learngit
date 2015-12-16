package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserAddressMapper;
import com.csj.gold.model.UserAddress;
import com.csj.gold.model.bean.MobileUserAddress;
import com.csj.gold.service.MobileUserAddressService;

@Service("mobileUserAddressService")
public class MobileUserAddressServiceImpl implements MobileUserAddressService {
	
	@Resource
	private UserAddressMapper userAddressMapper;

	@Override
	public List<UserAddress> searchByUserId(UserAddress userAddress) {
		return userAddressMapper.searchByUserId(userAddress);
	}

	@Override
	public int changeMainAddress(UserAddress userAddress) {
		if(userAddressMapper.resetMainAddress(userAddress)>0){
			return userAddressMapper.setMainAddress(userAddress);
		}
		return 0;
	}

	@Override
	public int deleteAddress(UserAddress userAddress) {
		return userAddressMapper.updateDeleteByPrimaryKey(userAddress);
	}

	@Override
	public int addAddress(UserAddress userAddress) {
		return userAddressMapper.insertSelective(userAddress);
	}

	@Override
	public int updateAddress(UserAddress userAddress) {
		return userAddressMapper.updateByPrimaryKeySelective(userAddress);
	}

}
