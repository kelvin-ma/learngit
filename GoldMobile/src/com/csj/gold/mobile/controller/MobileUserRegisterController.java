package com.csj.gold.mobile.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.vo.MobileForgetPasswordParams;
import com.csj.gold.mobile.vo.MobileForgetPasswordResult;
import com.csj.gold.mobile.vo.MobileLogoutParams;
import com.csj.gold.mobile.vo.MobileLogoutResult;
import com.csj.gold.mobile.vo.MobileUserRegisterParams;
import com.csj.gold.mobile.vo.MobileUserRegisterResult;
import com.csj.gold.mobile.vo.MobileUserRegisterVO;
import com.csj.gold.model.UserInfo;
import com.csj.gold.model.bean.MobileUserAllInfo;
import com.csj.gold.model.bean.MobileUserRegister;
import com.csj.gold.service.MobileUserRegisterService;
import com.csj.gold.service.UserInfoService;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping("/register")
public class MobileUserRegisterController {

	@Resource
	private MobileUserRegisterService mobileUserRegisterService;
	
	@Resource
	private UserInfoService userInfoService;

	@RequestMapping("/login")
	public String login(MobileUserRegisterParams mobileUserRegisterParams) {
		MobileUserRegisterResult mobileUserRegisterResult = new MobileUserRegisterResult();
		MobileUserRegister mobileUserRegister = new MobileUserRegister();
		MobileUserRegisterVO MobileUserRegisterVO = new MobileUserRegisterVO();
		if (null != mobileUserRegisterParams.getPhone()
				&& mobileUserRegisterParams.getPhone().trim().length() > 0
				&& null != mobileUserRegisterParams.getPassword()
				&& mobileUserRegisterParams.getPassword().trim().length() > 0) {
			mobileUserRegister.setPhone(mobileUserRegisterParams.getPhone());
			List<MobileUserRegister> userList = mobileUserRegisterService
					.searchByUserPhone(mobileUserRegister);
			mobileUserRegister = null;
			if (userList == null || userList.size() == 0) {
				// ??? 无用户 操作
			} else if (userList.size() > 1) {
				// ??? 查询结果用户过多，需联系管理员
			} else {
				mobileUserRegister = userList.get(0);
				if (mobileUserRegisterParams.getPassword().equals(
						mobileUserRegister.getPwd())) {
					// ？？？注册该用户到系统
					// ????登陆/////
				}
			}

		}
		return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
	}

	@RequestMapping("/regist")
	public String regist(MobileUserRegisterParams mobileUserRegisterParams) {
		MobileUserRegisterResult mobileUserRegisterResult = new MobileUserRegisterResult();
		MobileUserRegister mobileUserRegister = new MobileUserRegister();
		if (null != mobileUserRegisterParams.getPhone()
				&& mobileUserRegisterParams.getPhone().trim().length() > 0
				&& null != mobileUserRegisterParams.getPassword()
				&& mobileUserRegisterParams.getPassword().trim().length() > 0
				&& null != mobileUserRegisterParams.getPhoneCode()
				&& mobileUserRegisterParams.getPhoneCode().trim().length()> 0) {
			mobileUserRegister.setPhone(mobileUserRegisterParams.getPhone());
			List<MobileUserRegister> userList = mobileUserRegisterService
					.searchByUserPhone(mobileUserRegister);
			mobileUserRegister = null;
			if (null != userList && userList.size()>0) {
				// ??? 已注册
			}else {
				//if(mobileUserRegisterParams.getPhoneCode.equals(??????)){  ??? 验证码判断
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
					//???成功提示
				}
			   //}else{
				//??? 验证码错误提示
				//}
			}

		}
		return JsonConvert.getInstance().toJson(mobileUserRegisterResult);
	}
	
	@RequestMapping("/logout")
	public String logout(MobileLogoutParams mobileLogoutParams) {
		MobileLogoutResult mobileLogoutResult = new MobileLogoutResult();
		if (null != mobileLogoutParams.getPhone()
				&& mobileLogoutParams.getPhone().trim().length() > 0) {
			//????查询用户是否存在
			//？？？？如存在就登出
		}
		return JsonConvert.getInstance().toJson(mobileLogoutResult);
	}
	@RequestMapping("/forgetPassword")
	public String forgetPassword(MobileForgetPasswordParams mobileForgetPasswordParams) {
		MobileForgetPasswordResult MobileForgetPasswordResult = new MobileForgetPasswordResult();
		if (null != mobileForgetPasswordParams.getPhone()
				&& mobileForgetPasswordParams.getPhone().trim().length() > 0
				&& null != mobileForgetPasswordParams.getPassword()
				&& mobileForgetPasswordParams.getPassword().trim().length() > 0) {
			MobileUserRegister mobileUserRegister = new MobileUserRegister();
			//????查询用户是否存在
			mobileUserRegister.setPhone(mobileForgetPasswordParams.getPhone());
			mobileUserRegister.setPwd(mobileForgetPasswordParams.getPassword());
			int res = mobileUserRegisterService.forgetPassword(mobileUserRegister);
			//？？？验证是否修改成功
		}
		return JsonConvert.getInstance().toJson(MobileForgetPasswordResult);
	}

}
