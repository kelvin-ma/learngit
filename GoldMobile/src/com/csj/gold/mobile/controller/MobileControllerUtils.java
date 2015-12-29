package com.csj.gold.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.csj.gold.cache.MapCacheManager;
import com.csj.gold.model.bean.MobileUserAllInfo;

public class MobileControllerUtils {
	
	@SuppressWarnings("unchecked")
	protected static Map<String, HttpSession> getSessionMap(){
		return (Map<String, HttpSession>) MapCacheManager
				.getInstance().getMapCache().get("sessionMap");
	}
	
	@SuppressWarnings("unchecked")
	protected static Map<String,Map<String,Integer>> getMessageCodeMap(){
		return (Map<String,Map<String,Integer>>) MapCacheManager
				.getInstance().getMapCache().get("messageCodeMap");
	}
	
	protected static boolean checkUserLoginStatus(String userPhone, String phoneCode) {
		Map<String, HttpSession> sessionMap = getSessionMap();
		HttpSession sessionInMap = sessionMap.get(userPhone);
		if (null == sessionInMap || null == phoneCode
				|| null == sessionInMap.getAttribute("phoneCode")
				|| !phoneCode.equals(sessionInMap.getAttribute("phoneCode"))) {
			return false;
		}
		return true;
	}

	protected static boolean setUserAllInfoToSession(MobileUserAllInfo mobileUserAllInfo) {
		Map<String, HttpSession> sessionMap = getSessionMap();
		HttpSession sessionInMap = sessionMap.get(mobileUserAllInfo.getPhone());
		if (null == sessionInMap || null == mobileUserAllInfo) {
			sessionInMap.setAttribute("mobileUserAllInfo", mobileUserAllInfo);
			return true;
		}
		return false;
	}

	protected static MobileUserAllInfo getMobileUserAllInfoFromSession(String phone) {
		Map<String, HttpSession> sessionMap = getSessionMap();
		HttpSession sessionInMap = sessionMap.get(phone);
		if (null != sessionInMap) {
			return (MobileUserAllInfo) sessionInMap
					.getAttribute("mobileUserAllInfo");
		}
		return null;
	}
	
	protected static Map<String,Integer> getUserMessageCodeMapFromCacheMessageCodeMap(String phone){
		Map<String,Integer> userMap = getMessageCodeMap().get(phone);
		if(null == userMap){
			userMap = new HashMap<String,Integer>();
			getMessageCodeMap().put(phone, userMap);
		}
		return userMap;
	}
	
	
}
