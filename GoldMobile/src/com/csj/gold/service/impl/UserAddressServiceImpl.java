package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserAddressMapper;
import com.csj.gold.model.UserAddress;
import com.csj.gold.service.UserAddressService;
import com.csj.gold.utils.page.Page;

@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService{
	
	@Resource
	UserAddressMapper userAddressMapper = null;

	@Override
	public int add(UserAddress userAddress) {
		return userAddressMapper.insertSelective(userAddress);
	}

	@Override
	public int update(UserAddress userAddress) {
		return userAddressMapper.updateByPrimaryKeySelective(userAddress);
	}

	@Override
	public int delete(UserAddress userAddress) {
		return userAddressMapper.deleteByPrimaryKey(userAddress.getId());
	}

	@Override
	public int forbidden(UserAddress userAddress) {
		return userAddressMapper.forbiddenByPrimaryKey(userAddress.getId());
	}

	@Override
	public List<UserAddress> searchByParameters(Page page,UserAddress userAddress) {
		page.setParameters(userAddress);
		List<UserAddress> returnList = userAddressMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public UserAddress searchByPrimaryKey(UserAddress userAddress) {
		return userAddressMapper.selectByPrimaryKey(userAddress.getId());
	}

}
