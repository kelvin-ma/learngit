package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserLoginMapper;
import com.csj.gold.model.UserLogin;
import com.csj.gold.service.UserLoginService;
import com.csj.gold.utils.page.Page;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService{
	
	@Resource
	UserLoginMapper userLoginMapper = null;

	@Override
	public int add(UserLogin userLogin) {
		return userLoginMapper.insertSelective(userLogin);
	}

	@Override
	public int update(UserLogin userLogin) {
		return userLoginMapper.updateByPrimaryKeySelective(userLogin);
	}

	@Override
	public int delete(UserLogin userLogin) {
		return userLoginMapper.deleteByPrimaryKey(userLogin.getId());
	}

	@Override
	public int forbidden(UserLogin userLogin) {
		return userLoginMapper.forbiddenByPrimaryKey(userLogin.getId());
	}

	@Override
	public List<UserLogin> searchByParameters(Page page,UserLogin userLogin) {
		page.setParameters(userLogin);
		List<UserLogin> returnList = userLoginMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public UserLogin searchByPrimaryKey(UserLogin userLogin) {
		return userLoginMapper.selectByPrimaryKey(userLogin.getId());
	}

}
