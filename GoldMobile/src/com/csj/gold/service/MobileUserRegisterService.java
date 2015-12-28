package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.bean.MobileUserRegister;


public interface MobileUserRegisterService {
	List<MobileUserRegister> searchByUserPhone(MobileUserRegister mobileUserRegister);
	
	 int registerNewUser(MobileUserRegister mobileUserRegister);
	 
	 int forgetPassword(MobileUserRegister mobileUserRegister);
	
}
