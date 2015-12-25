package com.csj.gold.mobile.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;



import com.csj.gold.mobile.RegistTransation;
import com.csj.gold.mobile.annotation.MobileTranRegist;

import com.csj.gold.mobile.service.IMobileTransaction;
import com.csj.gold.mobile.vo.MobileParams;
import com.csj.gold.mobile.vo.MobileResult;
import com.csj.gold.mobile.vo.RegistParams;
import com.google.gson.reflect.TypeToken;

//@Service("mobileRegistService")
//@MobileTranRegist(tranNo=1000,classType=TypeToken.class)
public class MobileRegistServiceImpl implements IMobileTransaction{
	static{
		RegistTransation registTransation= RegistTransation.getInstance();
//		registTransation.registService(MobileConstant.regist, new TypeToken<RegistParams>() {
//				}.getType(), "mobileRegistService");
	}
	@Override
	public MobileResult doTransaction(MobileParams params,
			HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}


}
