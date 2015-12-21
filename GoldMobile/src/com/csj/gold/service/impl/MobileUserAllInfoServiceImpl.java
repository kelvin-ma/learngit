package com.csj.gold.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.MobileUserAllInfoMapper;
import com.csj.gold.dao.single.SysFileMapper;
import com.csj.gold.dao.single.UserBankcardMapper;
import com.csj.gold.dao.single.UserInfoMapper;
import com.csj.gold.dao.single.UserLoginMapper;
import com.csj.gold.model.SysFile;
import com.csj.gold.model.UserBankcard;
import com.csj.gold.model.UserInfo;
import com.csj.gold.model.UserLogin;
import com.csj.gold.model.bean.MobileUserAllInfo;
import com.csj.gold.service.MobileUserAllInfoService;

@Service("mobileUserAllInfoService")
public class MobileUserAllInfoServiceImpl implements MobileUserAllInfoService{
	
	@Resource
	private MobileUserAllInfoMapper mobileUserAllInfoMapper = null;
	
	@Resource
	private UserInfoMapper userInfoMapper = null;
	
	@Resource
	private UserBankcardMapper userBankcardMapper = null;
	
	@Resource
	private SysFileMapper sysFileMapper = null;
	
	@Resource
	private UserLoginMapper userLoginMapper = null;
	

	@Override
	public MobileUserAllInfo searchByUserId(MobileUserAllInfo mobileUserAllInfo) {
		return mobileUserAllInfoMapper.searchByUserId(mobileUserAllInfo);
	}

	@Override
	public int userIdentification(MobileUserAllInfo mobileUserAllInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addBankCard(MobileUserAllInfo mobileUserAllInfo) {
		UserBankcard  userBankcard = new UserBankcard();
		userBankcard.setBankCode(mobileUserAllInfo.getBankCode());
		userBankcard.setCardNumber(mobileUserAllInfo.getCardNumber());
		userBankcard.setUserId(mobileUserAllInfo.getUserId());
		userBankcard.setCreateDate(new Date());
		userBankcard.setCreateUser(mobileUserAllInfo.getUserId());
		userBankcard.setIsDel(0);
		userBankcard.setIsForbidden(0);
		return userBankcardMapper.insertSelective(userBankcard);
	}

	@Override
	public int removeBankCard(MobileUserAllInfo mobileUserAllInfo) {
		UserBankcard  userBankcard = new UserBankcard();
		userBankcard.setId(mobileUserAllInfo.getCardId());
		userBankcard.setIsDel(1);
		userBankcard.setUpdateDate(new Date());
		userBankcard.setUpdateUser(mobileUserAllInfo.getUserId());
		
		return userBankcardMapper.updateByPrimaryKeySelective(userBankcard);
	}

	@Override
	public int updateUserInfo(MobileUserAllInfo mobileUserAllInfo) {
		SysFile sysFile = new SysFile();
		sysFile.setFilePath(mobileUserAllInfo.getImageFilePath());
		sysFile.setIsDel(0);
		sysFile.setIsForbidden(0);
		sysFile.setCreateDate(new Date());
		sysFile.setCreateUser(mobileUserAllInfo.getUserId());
		sysFileMapper.insertSelective(sysFile);
		UserInfo userInfo = new UserInfo();
		userInfo.setHeadImageFileId(sysFile.getId());
		userInfo.setId(mobileUserAllInfo.getUserId());
		userInfo.setUpdateDate(new Date());
		userInfo.setUpdateUser(mobileUserAllInfo.getUserId());
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}
	
	@Override
	public int updateUserImage(MobileUserAllInfo mobileUserAllInfo) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(mobileUserAllInfo.getUserId());
		userInfo.setHeadImageFileId(mobileUserAllInfo.getImageId());
		userInfo.setUserName(mobileUserAllInfo.getUserName());
		userInfo.setUpdateDate(new Date());
		userInfo.setUpdateUser(mobileUserAllInfo.getUserId());
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	@Override
	public int changePassword(MobileUserAllInfo mobileUserAllInfo) {
		UserLogin userLogin =userLoginMapper.selectByPrimaryKey(mobileUserAllInfo.getUserId());
		if(null!= userLogin){
			if(userLogin.getUserPwd().equals(mobileUserAllInfo.getOldPassword())){
				userLogin.setUserPwd(mobileUserAllInfo.getNewPassword());
				userLogin.setUpdateDate(new Date());
				userLogin.setUpdateUser(mobileUserAllInfo.getUserId());
				return userLoginMapper.updateByPrimaryKeySelective(userLogin);
			}
		}
		return 0;
	}
	

}
