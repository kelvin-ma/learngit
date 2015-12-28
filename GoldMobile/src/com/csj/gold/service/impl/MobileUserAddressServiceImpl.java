package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserAddressMapper;
import com.csj.gold.model.UserAddress;
import com.csj.gold.service.MobileUserAddressService;
import com.csj.gold.utils.page.Page;

@Service("mobileUserAddressService")
public class MobileUserAddressServiceImpl implements MobileUserAddressService {
	
	@Resource
	private UserAddressMapper userAddressMapper;

	@Override
	public List<UserAddress> searchByUserId(UserAddress userAddress) {
		return userAddressMapper.searchByUserId(userAddress);
	}
	
	public List<UserAddress> searchByParameters(Page page,UserAddress userAddress) {
		page.setParameters(userAddress);
		return userAddressMapper.selectByParameters(page);
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
		return userAddressMapper.deleteByPrimaryKey(userAddress.getId());
	}
	
	@Override
	public int forbiddenAddress(UserAddress userAddress) {
		return userAddressMapper.forbiddenByPrimaryKey(userAddress.getId());
	}

	@Override
	public int addAddress(UserAddress userAddress) {
		return userAddressMapper.insertSelective(userAddress);
	}

	@Override
	public int updateAddress(UserAddress userAddress) {
		return userAddressMapper.updateByPrimaryKeySelective(userAddress);
	}

	@Override
	public UserAddress searchById(Long id) {
		return userAddressMapper.selectByPrimaryKey(id);
	}

}
