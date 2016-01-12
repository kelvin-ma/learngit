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

import com.csj.gold.mobile.common.MobileStateConstants;
import com.csj.gold.mobile.vo.MobileForgetPasswordParams;
import com.csj.gold.mobile.vo.MobileForgetPasswordResult;
import com.csj.gold.mobile.vo.MobileLogoutParams;
import com.csj.gold.mobile.vo.MobileLogoutResult;
import com.csj.gold.mobile.vo.MobileUserRegisterParams;
import com.csj.gold.mobile.vo.MobileUserRegisterResult;
import com.csj.gold.model.UserInfo;
import com.csj.gold.model.bean.MobileUserAllInfo;
import com.csj.gold.model.bean.MobileUserRegister;
import com.csj.gold.service.MobileUserAllInfoService;
import com.csj.gold.service.MobileUserRegisterService;
import com.csj.gold.service.UserInfoService;
import com.csj.gold.utils.StringUtils;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping(value="/register",produces="text/html;charset=UTF-8")
public class MobileUserRegisterController {
	private static Logger logger = Logger
			.getLogger(MobileUserRegisterController.class);

	@Resource
	private MobileUserRegisterService mobileUserRegisterService;

	@Resource
	private UserInfoService userInfoService;
	
	@Resource
	private MobileUserAllInfoService mobileUserAllInfoService;

	@ResponseBody
	@RequestMapping("/login")
	public String login(MobileUserRegisterParams mobileUserRegisterParams,
			HttpServletRequest httpServletRequest) {
		MobileUserRegisterResult mobileUserRegisterResult = new MobileUserRegisterResult();
		MobileUserRegister mobileUserRegister = new MobileUserRegister();
		Map<String, HttpSession> sessionMap = MobileControllerUtils
				.getSessionMap();
		HttpSession session = httpServletRequest.getSession();
		HttpSession sessionInMap = sessionMap.get(mobileUserRegisterParams
				.getPhone());
		Integer errorCount = 1;
		if (StringUtils.checkStringNullAndEmpty(mobileUserRegisterParams.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserRegisterParams.getPassword())) {
			if (null != sessionInMap
					&& null != sessionInMap.getAttribute("imageCode")) {
				if (null == mobileUserRegisterParams.getImageCode()) {
					mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NO_IMAGE_CODE.getIndex()));
					mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NO_IMAGE_CODE.getName());
					return JsonConvert.getInstance().toJson(
							mobileUserRegisterResult);
				} else if (!mobileUserRegisterParams
						.getImageCode()
						.equalsIgnoreCase(
								(String) sessionInMap.getAttribute("imageCode"))) {
					mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_IMAGE_CODE.getIndex()));
					mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_IMAGE_CODE.getName());
					return JsonConvert.getInstance().toJson(
							mobileUserRegisterResult);
				}
			}
			mobileUserRegister.setPhone(mobileUserRegisterParams.getPhone());
			List<MobileUserRegister> userList = mobileUserRegisterService
					.searchByUserPhone(mobileUserRegister);
			mobileUserRegister = null;
			if (userList == null || userList.size() == 0) {
				mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NO_USER.getIndex()));
				mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NO_USER.getName());
			} else if (userList.size() > 1) {
				mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.ERROR.getIndex()));
				mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.ERROR.getName());
			} else {
				mobileUserRegister = userList.get(0);
				if (mobileUserRegisterParams.getPassword().equals(
						mobileUserRegister.getPwd())) {
					mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
					mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
					session.setAttribute("userId", mobileUserRegister.getUserId());
					session.setAttribute("phoneCode",
							mobileUserRegisterParams.getPhoneCode());
					MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
					mobileUserAllInfo.setUserId(mobileUserRegister.getUserId());
					mobileUserAllInfo = mobileUserAllInfoService.searchByUserId(mobileUserAllInfo);
					System.out.println("Login:"+mobileUserAllInfo.getUserId());
					session.setAttribute("mobileUserAllInfo",mobileUserAllInfo);
					sessionMap
							.put(mobileUserRegisterParams.getPhone(), session);
				} else {
					mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PASSWORD.getIndex()));
					mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PASSWORD.getName());
					try {
						errorCount = (Integer) session
								.getAttribute("PasswordError");
						session.setAttribute("PasswordError", errorCount++);
					} catch (Exception e) {
						logger.error(e);
					}
					mobileUserRegisterResult.setPasswordErrorCount(errorCount);
				}
			}
		}else{
			mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
			mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
		}
		return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
	}

	@ResponseBody
	@RequestMapping("/regist")
	public String regist(MobileUserRegisterParams mobileUserRegisterParams,
			HttpServletRequest httpServletRequest) {
		MobileUserRegisterResult mobileUserRegisterResult = new MobileUserRegisterResult();
		MobileUserRegister mobileUserRegister = new MobileUserRegister();
		if (StringUtils.checkStringNullAndEmpty(mobileUserRegisterParams.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserRegisterParams.getPassword())
				&& StringUtils.checkStringNullAndEmpty(mobileUserRegisterParams.getPhoneCode())) {
			if(!MobileControllerUtils.checkMessageWasChecked(mobileUserRegisterParams.getPhone(), MobileMessageCodeController.CHECK_REGISTER_CODE)){
				mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PROCESS.getIndex()));
				mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PROCESS.getName());
				return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
			}
			mobileUserRegister.setPhone(mobileUserRegisterParams.getPhone());
			List<MobileUserRegister> userList = mobileUserRegisterService
					.searchByUserPhone(mobileUserRegister);
			mobileUserRegister = null;
			if (null != userList && userList.size() > 0) {
				mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.EXIST.getIndex()));
				mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.EXIST.getName());
				return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
			} else {
				UserInfo userInfo = new UserInfo();
				userInfo.setIsDel(0);
				userInfo.setIsForbidden(0);
				userInfo.setVersion(0);
				userInfo.setPhone(mobileUserRegisterParams.getPhone());
				userInfo.setCreateDate(new Date());
				int result = userInfoService.add(userInfo);
				if (result == 1) {
					mobileUserRegister = new MobileUserRegister();
					mobileUserRegister.setUserId(userInfo.getId());
					mobileUserRegister.setPwd(mobileUserRegisterParams
							.getPassword());
					mobileUserRegister.setPhone(mobileUserRegisterParams
							.getPhone());
					result = mobileUserRegisterService
							.registerNewUser(mobileUserRegister);
					if (result == 1) {
						mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
						mobileUserRegisterResult
								.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
					} else {
						mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.UNSUCCESS.getIndex()));
						mobileUserRegisterResult
								.setResultDesc(MobileStateConstants.MobileErrorConstants.UNSUCCESS.getName());
					}
				}
			}

		}else{
			mobileUserRegisterResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
			mobileUserRegisterResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
		}
		return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
	}

	@ResponseBody
	@RequestMapping("/logout")
	public String logout(MobileLogoutParams mobileLogoutParams,
			HttpServletRequest httpServletRequest) {
		MobileLogoutResult mobileLogoutResult = new MobileLogoutResult();
		Map<String, HttpSession> sessionMap = MobileControllerUtils
				.getSessionMap();
		if (null != mobileLogoutParams.getPhone()
				&& mobileLogoutParams.getPhone().trim().length() > 0
				&& null != sessionMap) {
			HttpSession sessionInMap = sessionMap.get(mobileLogoutParams
					.getPhone());
			if (null != sessionInMap) {
				//消除Session中登录信息
				sessionMap.remove(mobileLogoutParams.getPhone());
				//短信相关业务全部取消
				MobileControllerUtils.getMessageCodeMap().put(mobileLogoutParams.getPhone(), null);
				mobileLogoutResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
				mobileLogoutResult.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
			}
		} else {
			mobileLogoutResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
			mobileLogoutResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
		}
		return JsonConvert.getInstance().toJson(mobileLogoutResult);
	}

	@ResponseBody
	@RequestMapping("/forgetPassword")
	public String forgetPassword(
			MobileForgetPasswordParams mobileForgetPasswordParams,
			HttpServletRequest httpServletRequest) {
		MobileForgetPasswordResult mobileForgetPasswordResult = new MobileForgetPasswordResult();
		if (null != mobileForgetPasswordParams.getPhone()
				&& mobileForgetPasswordParams.getPhone().trim().length() > 0) {
			if(!MobileControllerUtils.checkMessageWasChecked(mobileForgetPasswordParams.getPhone(), MobileMessageCodeController.CHECK_FORGET_PASSWORD_CODE)){
				mobileForgetPasswordResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PROCESS.getIndex()));
				mobileForgetPasswordResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PROCESS.getName());
				return JsonConvert.getInstance().toJson(mobileForgetPasswordResult);
			}
			if (null != mobileForgetPasswordParams.getPassword()
					&& mobileForgetPasswordParams.getPassword().trim().length() > 0) {
				MobileUserRegister mobileUserRegister = new MobileUserRegister();
				mobileUserRegister.setPhone(mobileForgetPasswordParams
						.getPhone());
				List<MobileUserRegister> userList = mobileUserRegisterService
						.searchByUserPhone(mobileUserRegister);
				if (null == userList || userList.size() == 0) {
					mobileForgetPasswordResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NO_USER.getIndex()));
					mobileForgetPasswordResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NO_USER.getName());
				} else if (userList.size() > 1) {
					mobileForgetPasswordResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.ERROR.getIndex()));
					mobileForgetPasswordResult.setResultDesc(MobileStateConstants.MobileErrorConstants.ERROR.getName());
				} else {
					mobileUserRegister.setPwd(mobileForgetPasswordParams
							.getPassword());
					int res = mobileUserRegisterService
							.forgetPassword(mobileUserRegister);
					if (res == 1) {
						mobileForgetPasswordResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
						mobileForgetPasswordResult
								.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
					}else{
						mobileForgetPasswordResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.UNSUCCESS.getIndex()));
						mobileForgetPasswordResult
						.setResultDesc(MobileStateConstants.MobileErrorConstants.UNSUCCESS.getName());
					}
				}
			}else{
				mobileForgetPasswordResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
				mobileForgetPasswordResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
			}
		} else {
			mobileForgetPasswordResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
			mobileForgetPasswordResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
		}
		return JsonConvert.getInstance().toJson(mobileForgetPasswordResult);
	}

}
