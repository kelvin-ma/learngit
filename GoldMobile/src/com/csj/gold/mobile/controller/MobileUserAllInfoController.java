package com.csj.gold.mobile.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.cache.MapCacheManager;
import com.csj.gold.mobile.vo.MobileUserAllInfoParams;
import com.csj.gold.mobile.vo.MobileUserAllInfoResult;
import com.csj.gold.mobile.vo.MobileUserAllInfoVO;
import com.csj.gold.model.bean.MobileUserAllInfo;
import com.csj.gold.service.MobileUserAllInfoService;
import com.csj.gold.utils.file.FileUtil;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping("/user")
public class MobileUserAllInfoController {
	private static Logger logger = Logger
			.getLogger(MobileUserAllInfoController.class);

	@Resource
	private MobileUserAllInfoService mobileUserAllInfoService;

	@ResponseBody
	@RequestMapping("/mypage")
	public String mypage(MobileUserAllInfoParams mobileUserAllInfoParams) {
		MobileUserAllInfoResult mobileUserAllInfoResult = new MobileUserAllInfoResult();
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		MobileUserAllInfoVO mobileUserAllInfoVO = new MobileUserAllInfoVO();
		if (!checkUserLoginStatus(mobileUserAllInfoParams.getPhone(),
				mobileUserAllInfoParams.getPhoneCode())) {
			mobileUserAllInfoResult.setResultDesc("未登录");
			return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
		}
		if (null != mobileUserAllInfoParams.getUserId()) {
			mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
			mobileUserAllInfo = mobileUserAllInfoService
					.searchByUserId(mobileUserAllInfo);
			if (null != mobileUserAllInfo) {
				mobileUserAllInfoVO
						.setBankCode(mobileUserAllInfo.getBankCode());
				mobileUserAllInfoVO
						.setBankName(mobileUserAllInfo.getBankName());
				mobileUserAllInfoVO.setCardNumber(mobileUserAllInfo
						.getCardNumber());
				mobileUserAllInfoVO.setCertNo(mobileUserAllInfo.getCertNo());
				mobileUserAllInfoVO.setCardId(mobileUserAllInfo.getCardId());
				mobileUserAllInfoVO.setImageFilePath(mobileUserAllInfo
						.getImageFilePath());
				mobileUserAllInfoVO.setPhone(mobileUserAllInfo.getPhone());
				mobileUserAllInfoVO.setUserId(mobileUserAllInfo.getUserId());
				mobileUserAllInfoVO
						.setUserName(mobileUserAllInfo.getUserName());
				this.setUserAllInfoToSession(mobileUserAllInfo);
			}
		}
		mobileUserAllInfoResult.setData(mobileUserAllInfoVO);
		return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
	}

	@ResponseBody
	@RequestMapping("/userIdentification")
	public String userIdentification(
			MobileUserAllInfoParams mobileUserAllInfoParams) {
		MobileUserAllInfoResult mobileUserAllInfoResult  = new MobileUserAllInfoResult();
		if(!checkUserLoginStatus(mobileUserAllInfoParams.getPhone(),mobileUserAllInfoParams.getPhoneCode())){
			mobileUserAllInfoResult.setResultDesc("未登录");
			return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
		}
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
		mobileUserAllInfo.setCertNo(mobileUserAllInfoParams.getCertNo());
		mobileUserAllInfo.setUserName(mobileUserAllInfoParams.getUserName());
		int res = mobileUserAllInfoService.userIdentification(mobileUserAllInfo);
		MobileUserAllInfoVO mobileUserAllInfoVO = new MobileUserAllInfoVO(); 
		if(res == 1){
			mobileUserAllInfo = this.getMobileUserAllInfoFromSession(mobileUserAllInfoParams.getPhone());
			if (null != mobileUserAllInfo) {
				mobileUserAllInfoVO
						.setBankCode(mobileUserAllInfo.getBankCode());
				mobileUserAllInfoVO
						.setBankName(mobileUserAllInfo.getBankName());
				mobileUserAllInfoVO.setCardNumber(mobileUserAllInfo
						.getCardNumber());
				mobileUserAllInfoVO.setCertNo(mobileUserAllInfo.getCertNo());
				mobileUserAllInfoVO.setCardId(mobileUserAllInfo.getCardId());
				mobileUserAllInfoVO.setImageFilePath(mobileUserAllInfo
						.getImageFilePath());
				mobileUserAllInfoVO.setPhone(mobileUserAllInfo.getPhone());
				mobileUserAllInfoVO.setUserId(mobileUserAllInfo.getUserId());
				mobileUserAllInfoVO
						.setUserName(mobileUserAllInfo.getUserName());
			}
			mobileUserAllInfoResult.setResultDesc("认证成功");
			mobileUserAllInfoResult.setData(mobileUserAllInfoVO);
		}
		return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
	}

	@ResponseBody
	@RequestMapping("/userImageUpload")
	public String userImageUpload(
			MobileUserAllInfoParams mobileUserAllInfoParams) {
		String filePath = null;
		if (null != mobileUserAllInfoParams.getUserImage()) {
			try {
				filePath = FileUtil.uploadFile(mobileUserAllInfoParams
						.getUserImage());
			} catch (IOException e) {
				return null;
			}
		}
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
		mobileUserAllInfo.setImageFilePath(filePath);
		mobileUserAllInfoService.updateUserImage(mobileUserAllInfo);
		return null;
	}

	@ResponseBody
	@RequestMapping("/changePassword")
	public String changePassword(MobileUserAllInfoParams mobileUserAllInfoParams) {
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
		mobileUserAllInfo.setOldPassword(mobileUserAllInfoParams
				.getOldPassword());
		mobileUserAllInfo.setNewPassword(mobileUserAllInfoParams
				.getNewPassword());
		mobileUserAllInfoService.changePassword(mobileUserAllInfo);
		return null;
	}

	private boolean checkUserLoginStatus(String userPhone, String phoneCode) {
		Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) MapCacheManager
				.getInstance().getMapCache().get("sessionMap");
		HttpSession sessionInMap = sessionMap.get(userPhone);
		if (null == sessionInMap || null != phoneCode
				|| null == sessionInMap.getAttribute("phoneCode")
				|| !phoneCode.equals(sessionInMap.getAttribute("phoneCode"))) {
			return false;
		}
		return true;
	}

	private boolean setUserAllInfoToSession(MobileUserAllInfo mobileUserAllInfo) {
		Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) MapCacheManager
				.getInstance().getMapCache().get("sessionMap");
		HttpSession sessionInMap = sessionMap.get(mobileUserAllInfo.getPhone());
		if (null == sessionInMap || null == mobileUserAllInfo) {
			sessionInMap.setAttribute("mobileUserAllInfo", mobileUserAllInfo);
			return true;
		}
		return false;
	}

	private MobileUserAllInfo getMobileUserAllInfoFromSession(String phone) {
		Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) MapCacheManager
				.getInstance().getMapCache().get("sessionMap");
		HttpSession sessionInMap = sessionMap.get(phone);
		if (null != sessionInMap) {
			return (MobileUserAllInfo) sessionInMap
					.getAttribute("mobileUserAllInfo");
		}
		return null;
	}

}
