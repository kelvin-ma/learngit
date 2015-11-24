package com.csj.gold.mobile.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.UserInfoMapper;
import com.csj.gold.mobile.model.UserInfo;
import com.csj.gold.mobile.service.UserInfoService;



@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper userMapper;
	
	public UserInfo searchById(Integer id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Transactional
	public int insert(UserInfo user) {
		return userMapper.insert(user);
	}
	
	@Transactional
	public int update(UserInfo user) {
		return userMapper.updateByPrimaryKey(user);
	}
	
	@Transactional
	public int delete(Integer id){
		return userMapper.deleteByPrimaryKey(id);
	}
	
//	public Page search(Page pager) {
//		if(pager == null){
//		  pager = new Page();
//		}
//		List<User> items = userMapper.search(pager);
//		pager.setDatas(items);	  
//		return pager;
//	}
}