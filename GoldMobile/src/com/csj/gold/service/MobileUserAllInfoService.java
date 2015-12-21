package com.csj.gold.service;

import com.csj.gold.model.bean.MobileUserAllInfo;


public interface MobileUserAllInfoService {
	 MobileUserAllInfo searchByUserId(MobileUserAllInfo mobileUserAllInfo);
	
	 int userIdentification(MobileUserAllInfo mobileUserAllInfo);
	
	 int addBankCard(MobileUserAllInfo mobileUserAllInfo);
	
	 int removeBankCard(MobileUserAllInfo mobileUserAllInfo);
	 
	 int updateUserInfo(MobileUserAllInfo mobileUserAllInfo);
	 
	 int updateUserImage(MobileUserAllInfo mobileUserAllInfo);

	 int changePassword(MobileUserAllInfo mobileUserAllInfo);
	
}
