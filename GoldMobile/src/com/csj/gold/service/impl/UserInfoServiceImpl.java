package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserInfoMapper;
import com.csj.gold.model.SysFile;
import com.csj.gold.model.UserInfo;
import com.csj.gold.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	
	@Resource
	UserInfoMapper userInfoMapper = null;

	@Override
	public int add(UserInfo userInfo) {
		return userInfoMapper.insertSelective(userInfo);
	}

	@Override
	public int update(UserInfo userInfo) {
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	@Override
	public int delete(UserInfo userInfo) {
		return userInfoMapper.deleteByPrimaryKey(userInfo.getId());
	}

	@Override
	public int forbidden(UserInfo userInfo) {
		return userInfoMapper.forbiddenByPrimaryKey(userInfo.getId());
	}

	@Override
	public List<UserInfo> searchByParameters(UserInfo userInfo) {
		List<UserInfo> returnList = userInfoMapper.selectByParameters(userInfo);
		return returnList;
	}

	@Override
	public UserInfo searchByPrimaryKey(UserInfo userInfo) {
		return userInfoMapper.selectByPrimaryKey(userInfo.getId());
	}

}
