package com.csj.gold.mobile.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.cache.MapCacheManager;
import com.csj.gold.mobile.vo.MobileForgetPasswordParams;
import com.csj.gold.mobile.vo.MobileForgetPasswordResult;
import com.csj.gold.mobile.vo.MobileLogoutParams;
import com.csj.gold.mobile.vo.MobileLogoutResult;
import com.csj.gold.mobile.vo.MobileUserRegisterParams;
import com.csj.gold.mobile.vo.MobileUserRegisterResult;
import com.csj.gold.model.UserInfo;
import com.csj.gold.model.bean.MobileUserRegister;
import com.csj.gold.service.MobileUserRegisterService;
import com.csj.gold.service.UserInfoService;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping("/register")
public class MobileUserRegisterController {
	private static Logger logger = Logger.getLogger(MobileUserRegisterController.class);
	
	@Resource
	private MobileUserRegisterService mobileUserRegisterService;
	
	@Resource
	private UserInfoService userInfoService;

	@ResponseBody
	@RequestMapping("/login")
	public String login(MobileUserRegisterParams mobileUserRegisterParams,HttpServletRequest httpServletRequest) {
		MobileUserRegisterResult mobileUserRegisterResult = new MobileUserRegisterResult();
		MobileUserRegister mobileUserRegister = new MobileUserRegister();
		Map<String,HttpSession> sessionMap = MobileControllerUtils.getSessionMap();
		HttpSession session = httpServletRequest.getSession();
		HttpSession sessionInMap = sessionMap.get(mobileUserRegisterParams.getPhone());
		Integer errorCount = 1;
		if (null != mobileUserRegisterParams.getPhone()
				&& mobileUserRegisterParams.getPhone().trim().length() > 0
				&& null != mobileUserRegisterParams.getPassword()
				&& mobileUserRegisterParams.getPassword().trim().length() > 0) {
			if(null !=sessionInMap && null != sessionInMap.getAttribute("imageCode")){
				if(null == mobileUserRegisterParams.getImageCode()){
					mobileUserRegisterResult.setResultDesc("No ImageCode！！！");
					return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
				}else if(!mobileUserRegisterParams.getImageCode().equalsIgnoreCase((String)sessionInMap.getAttribute("imageCode"))){
					mobileUserRegisterResult.setResultDesc("Wrong ImageCode");
					return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
				}
			}
			mobileUserRegister.setPhone(mobileUserRegisterParams.getPhone());
			List<MobileUserRegister> userList = mobileUserRegisterService
					.searchByUserPhone(mobileUserRegister);
			mobileUserRegister = null;
			if (userList == null || userList.size() == 0) {
				mobileUserRegisterResult.setResultDesc("No User");
			} else if (userList.size() > 1) {
				mobileUserRegisterResult.setResultDesc("Too Many User");
			} else {
				mobileUserRegister = userList.get(0);
				if (mobileUserRegisterParams.getPassword().equals(
						mobileUserRegister.getPwd())) {
					mobileUserRegisterResult.setResultDesc("Login Success");
					session.setAttribute("phoneCode", mobileUserRegisterParams.getPhoneCode());
					sessionMap.put(mobileUserRegisterParams.getPhone(),session);
				}else{
					mobileUserRegisterResult.setResultDesc("Password Error");
					try{
					errorCount = (Integer)session.getAttribute("PasswordError");
					session.setAttribute("PasswordError",errorCount++);
					}catch (Exception e) {
						logger.error(e);
					}
					mobileUserRegisterResult.setPasswordErrorCount(errorCount);
				}
			}
		}
		return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
	}
	@ResponseBody
	@RequestMapping("/regist")
	public String regist(MobileUserRegisterParams mobileUserRegisterParams,HttpServletRequest httpServletRequest) {
		MobileUserRegisterResult mobileUserRegisterResult = new MobileUserRegisterResult();
		MobileUserRegister mobileUserRegister = new MobileUserRegister();
		Map<String,HttpSession> sessionMap = MobileControllerUtils.getSessionMap();
		HttpSession sessionInMap = sessionMap.get(mobileUserRegisterParams.getPhone());
		String message = (String)sessionInMap.getAttribute("messageCode");
		if(null == message || message.trim().length()==0 || null == mobileUserRegisterParams.getMessageCode() || mobileUserRegisterParams.getMessageCode().trim().length()==0){
			mobileUserRegisterResult.setResultDesc("No MessageCode！！");
			return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
		}else if(!message.trim().equalsIgnoreCase(mobileUserRegisterParams.getMessageCode().trim())){
			mobileUserRegisterResult.setResultDesc("Wrong MessageCode！！");
			return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
		}
		if (null != mobileUserRegisterParams.getPhone()
				&& mobileUserRegisterParams.getPhone().trim().length() > 0
				&& null != mobileUserRegisterParams.getPassword()
				&& mobileUserRegisterParams.getPassword().trim().length() > 0
				&& null != mobileUserRegisterParams.getPhoneId()
				&& mobileUserRegisterParams.getPhoneId().trim().length()> 0) {
			mobileUserRegister.setPhone(mobileUserRegisterParams.getPhone());
			List<MobileUserRegister> userList = mobileUserRegisterService
					.searchByUserPhone(mobileUserRegister);
			mobileUserRegister = null;
			if (null != userList && userList.size()>0) {
				// ??? 已注册
			}else {
				UserInfo userInfo = new UserInfo();
				userInfo.setIsDel(0);
				userInfo.setIsForbidden(0);
				userInfo.setPhone(mobileUserRegisterParams.getPhone());
				userInfo.setCreateDate(new Date());
				int result = userInfoService.add(userInfo);
				if(result == 1){
					mobileUserRegister = new MobileUserRegister();
					mobileUserRegister.setUserId(userInfo.getId());
					mobileUserRegister.setPwd(mobileUserRegisterParams.getPassword());
					mobileUserRegister.setPhone(mobileUserRegisterParams.getPhone());
					result = mobileUserRegisterService.registerNewUser(mobileUserRegister);
					if(result == 1){
						mobileUserRegisterResult.setResultDesc("Regist Success");
					}else{
						mobileUserRegisterResult.setResultDesc("Regist Unsuccess");
					}
				}
			}

		}
		return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
	}
	@ResponseBody
	@RequestMapping("/logout")
	public String logout(MobileLogoutParams mobileLogoutParams,HttpServletRequest httpServletRequest) {
		MobileLogoutResult mobileLogoutResult = new MobileLogoutResult();
		Map<String,HttpSession> sessionMap = MobileControllerUtils.getSessionMap();
		HttpSession sessionInMap = sessionMap.get(mobileLogoutParams.getPhone());
		if (null != mobileLogoutParams.getPhone()
				&& mobileLogoutParams.getPhone().trim().length() > 0) {
			if (null!=sessionInMap){
				sessionMap.remove(mobileLogoutParams.getPhone());
			}
		}
		return JsonConvert.getInstance().toJson(mobileLogoutResult);
	}
	@ResponseBody
	@RequestMapping("/forgetPassword")
	public String forgetPassword(MobileForgetPasswordParams mobileForgetPasswordParams,HttpServletRequest httpServletRequest) {
		MobileForgetPasswordResult MobileForgetPasswordResult = new MobileForgetPasswordResult();
		Map<String,HttpSession> sessionMap = MobileControllerUtils.getSessionMap();
		HttpSession sessionInMap = sessionMap.get(mobileForgetPasswordParams.getPhone());
		String message = (String)sessionInMap.getAttribute("messageCode");
		if(null == message || message.trim().length()==0 || null == mobileForgetPasswordParams.getMessageCode() || mobileForgetPasswordParams.getMessageCode().trim().length()==0){
			MobileForgetPasswordResult.setResultDesc("No MessageCode！！");
			return JsonConvert.getInstance().toJson(MobileForgetPasswordResult);
		}else if(!message.trim().equalsIgnoreCase(mobileForgetPasswordParams.getMessageCode().trim())){
			MobileForgetPasswordResult.setResultDesc("Wrong MessageCode！！");
			return JsonConvert.getInstance().toJson(MobileForgetPasswordResult);
		}
		if (null != mobileForgetPasswordParams.getPhone()
				&& mobileForgetPasswordParams.getPhone().trim().length() > 0
				&& null != mobileForgetPasswordParams.getPassword()
				&& mobileForgetPasswordParams.getPassword().trim().length() > 0) {
			MobileUserRegister mobileUserRegister = new MobileUserRegister();
			//????查询用户是否存在
			mobileUserRegister.setPhone(mobileForgetPasswordParams.getPhone());
			List<MobileUserRegister> userList = mobileUserRegisterService.searchByUserPhone(mobileUserRegister);
			if(null==userList || userList.size()==0){
				MobileForgetPasswordResult.setResultDesc("No User");
			}else if(userList.size()>1){
				MobileForgetPasswordResult.setResultDesc("Too Many User");
			}else{
				mobileUserRegister.setPwd(mobileForgetPasswordParams.getPassword());
				int res = mobileUserRegisterService.forgetPassword(mobileUserRegister);
				if(res == 1){
					MobileForgetPasswordResult.setResultDesc("Update Success");
				}
			}
		}
		return JsonConvert.getInstance().toJson(MobileForgetPasswordResult);
	}

}
