package com.csj.gold.mobile.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		if (!MobileControllerUtils.checkUserLoginStatus(mobileUserAllInfoParams.getPhone(),
				mobileUserAllInfoParams.getPhoneCode())) {
			mobileUserAllInfoResult.setResultDesc("Not Login");
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
				MobileControllerUtils.setUserAllInfoToSession(mobileUserAllInfo);
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
		if(!MobileControllerUtils.checkUserLoginStatus(mobileUserAllInfoParams.getPhone(),mobileUserAllInfoParams.getPhoneCode())){
			mobileUserAllInfoResult.setResultDesc("Not Login");
			return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
		}
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
		mobileUserAllInfo.setCertNo(mobileUserAllInfoParams.getCertNo());
		mobileUserAllInfo.setUserName(mobileUserAllInfoParams.getUserName());
		int res = mobileUserAllInfoService.userIdentification(mobileUserAllInfo);
		MobileUserAllInfoVO mobileUserAllInfoVO = new MobileUserAllInfoVO(); 
		if(res == 1){
			mobileUserAllInfo = MobileControllerUtils.getMobileUserAllInfoFromSession(mobileUserAllInfoParams.getPhone());
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
				MobileControllerUtils.setUserAllInfoToSession(mobileUserAllInfo);
			}
			mobileUserAllInfoResult.setResultDesc("Identifacation Success");
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

	

}
