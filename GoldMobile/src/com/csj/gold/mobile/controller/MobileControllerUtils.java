package com.csj.gold.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.csj.gold.cache.MapCacheManager;
import com.csj.gold.model.bean.MobileUserAllInfo;
import com.csj.gold.utils.StringUtils;

/**
 * @author Cer
 *
 */
public class MobileControllerUtils {
	
	/**
	 * 取得Session的Map<电话号，Session>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static Map<String, HttpSession> getSessionMap(){
		return (Map<String, HttpSession>) MapCacheManager
				.getInstance().getMapCache().get("sessionMap");
	}
	
	/**
	 * 取得短信业务Map<电话号，Map<业务code，状态值>>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static Map<String,Map<String,Integer>> getMessageCodeMap(){
		return (Map<String,Map<String,Integer>>) MapCacheManager
				.getInstance().getMapCache().get("messageCodeMap");
	}
	
	/**
	 * 查看该手机号的登录状态
	 * @param userPhone
	 * @param phoneCode
	 * @return
	 */
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

	/**
	 * 将登录信息录入到以电话号为key的Session中
	 * @param mobileUserAllInfo
	 * @return
	 */
	protected static boolean setUserAllInfoToSession(MobileUserAllInfo mobileUserAllInfo) {
		Map<String, HttpSession> sessionMap = getSessionMap();
		HttpSession sessionInMap = sessionMap.get(mobileUserAllInfo.getPhone());
		if (null == sessionInMap || null == mobileUserAllInfo) {
			sessionInMap.setAttribute("mobileUserAllInfo", mobileUserAllInfo);
			return true;
		}
		return false;
	}

	/**
	 * 取得Session中登录信息
	 * @param phone
	 * @return
	 */
	protected static MobileUserAllInfo getMobileUserAllInfoFromSession(String phone) {
		Map<String, HttpSession> sessionMap = getSessionMap();
		HttpSession sessionInMap = sessionMap.get(phone);
		if (null != sessionInMap) {
			return (MobileUserAllInfo) sessionInMap
					.getAttribute("mobileUserAllInfo");
		}
		return null;
	}
	
	/**
	 * 取得内存中该电话号所有短信业务验证状态Map
	 * @param phone 电话号
	 * @return
	 */
	protected static Map<String,Integer> getUserMessageCodeMapFromCacheMessageCodeMap(String phone){
		Map<String,Integer> userMap = getMessageCodeMap().get(phone);
		if(null == userMap){
			userMap = new HashMap<String,Integer>();
			getMessageCodeMap().put(phone, userMap);
		}
		return userMap;
	}
	
	/**
	 * 判断短信是否被验证过
	 * @param phone 电话号
	 * @param checkCode 业务代码
	 * @return
	 */
	protected static boolean checkMessageWasChecked(String phone,String checkCode){
		Map<String,Integer> userMessageCodeMap = null;
		if(null != MobileControllerUtils.getMessageCodeMap()){
			userMessageCodeMap =MobileControllerUtils.getMessageCodeMap().get(phone);
			if(userMessageCodeMap.get(checkCode)!=1){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}
	
	protected static Long getUserIdFromSession(String phone){
		Long id = null;
		if(StringUtils.checkStringNullAndEmpty(phone)){
			HttpSession userSession = MobileControllerUtils.getSessionMap().get(phone);
			if(null!= userSession){
				id = (Long)userSession.getAttribute("userId");
			}
		}
		return id;
	}
}
