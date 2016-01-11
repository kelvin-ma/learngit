package com.csj.gold.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserLoginMapper;
import com.csj.gold.model.UserLogin;
import com.csj.gold.model.bean.MobileUserRegister;
import com.csj.gold.service.MobileUserRegisterService;

@Service("mobileUserRegisterService")
public class MobileUserRegisterServiceImpl implements MobileUserRegisterService{
	
	@Resource
	private UserLoginMapper userLoginMapper = null;

	@Override
	public List<MobileUserRegister> searchByUserPhone(
			MobileUserRegister mobileUserRegister) {
		UserLogin user = new UserLogin();
		user.setUserPhone(mobileUserRegister.getPhone());
		user.setIsDel(0);
		user.setIsForbidden(0);
		List<UserLogin> userList = userLoginMapper.selectByPhone(user);
		if(null ==  userList || userList.size()==0){
			return null;
		}
		MobileUserRegister tempMUR = null;
		List<MobileUserRegister> returnList = new ArrayList<MobileUserRegister>();
		for(UserLogin temp : userList){
			tempMUR = new MobileUserRegister();
			tempMUR.setUserId(temp.getUserId());
			tempMUR.setPhone(temp.getUserPhone());
			tempMUR.setPwd(temp.getUserPwd());
			returnList.add(tempMUR);
		}
		return returnList;
	}

	@Override
	public int registerNewUser(MobileUserRegister mobileUserRegister) {
		UserLogin user = new UserLogin();
		user.setIsDel(0);
		user.setIsForbidden(0);
		user.setVersion(0);
		user.setUserId(mobileUserRegister.getUserId());
		user.setUserPhone(mobileUserRegister.getPhone());
		user.setUserPwd(mobileUserRegister.getPwd());
		List<UserLogin> userList = userLoginMapper.selectByPhone(user);
		if(null != userList && userList.size()>0){
			return 0;
		}
		user.setCreateDate(new Date());
		user.setUserPwd(mobileUserRegister.getPwd());
		return userLoginMapper.insertSelective(user);
	}
	
	@Override
	public int forgetPassword(MobileUserRegister mobileUserRegister) {
		UserLogin user = new UserLogin();
		user.setIsDel(0);
		user.setIsForbidden(0);
		user.setUserPhone(mobileUserRegister.getPhone());
		List<UserLogin> userList = userLoginMapper.selectByPhone(user);
		if(null == userList || userList.size()!=1){
			return 0;
		}
		user = userList.get(0);
		user.setUserPwd(mobileUserRegister.getPwd());
		return userLoginMapper.updateByPrimaryKeySelective(user);
	}
	

}
