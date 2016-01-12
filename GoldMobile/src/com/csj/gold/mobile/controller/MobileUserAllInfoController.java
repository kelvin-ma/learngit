package com.csj.gold.mobile.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.common.MobileStateConstants;
import com.csj.gold.mobile.vo.MobileUserAllInfoParams;
import com.csj.gold.mobile.vo.MobileUserAllInfoResult;
import com.csj.gold.mobile.vo.MobileUserAllInfoVO;
import com.csj.gold.model.bean.MobileUserAllInfo;
import com.csj.gold.service.MobileUserAllInfoService;
import com.csj.gold.utils.StringUtils;
import com.csj.gold.utils.file.FileUtil;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping(value="/user",produces="text/html;charset=UTF-8")
public class MobileUserAllInfoController {
	@SuppressWarnings("unused")
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
		if (StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
						.getPhoneCode())) {
			if (!MobileControllerUtils.checkUserLoginStatus(
					mobileUserAllInfoParams.getPhone(),
					mobileUserAllInfoParams.getPhoneCode())) {
				mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getIndex()));
				mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getName());
				return JsonConvert.getInstance()
						.toJson(mobileUserAllInfoResult);
			}
			Long id = MobileControllerUtils.getUserIdFromSession(mobileUserAllInfoParams.getPhone());
			if(null == id || id < 1){
				mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
				mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
				return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
			}
			mobileUserAllInfo.setUserId(id);
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
				mobileUserAllInfoVO
						.setUserName(mobileUserAllInfo.getUserName());
				MobileControllerUtils
						.setUserAllInfoToSession(mobileUserAllInfo);
			}
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
			mobileUserAllInfoResult.setData(mobileUserAllInfoVO);
		} else {
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
		}
		return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
	}

	@ResponseBody
	@RequestMapping("/userIdentification")
	public String userIdentification(
			MobileUserAllInfoParams mobileUserAllInfoParams) {
		MobileUserAllInfoResult mobileUserAllInfoResult = new MobileUserAllInfoResult();
		if (!MobileControllerUtils.checkUserLoginStatus(
				mobileUserAllInfoParams.getPhone(),
				mobileUserAllInfoParams.getPhoneCode())) {
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getIndex()));
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getName());
			return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
		}
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
		mobileUserAllInfo.setCertNo(mobileUserAllInfoParams.getCertNo());
		mobileUserAllInfo.setUserName(mobileUserAllInfoParams.getUserName());
		int res = mobileUserAllInfoService
				.userIdentification(mobileUserAllInfo);
		MobileUserAllInfoVO mobileUserAllInfoVO = new MobileUserAllInfoVO();
		if (res == 1) {
			mobileUserAllInfo = MobileControllerUtils
					.getMobileUserAllInfoFromSession(mobileUserAllInfoParams
							.getPhone());
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
				mobileUserAllInfoVO
						.setUserName(mobileUserAllInfo.getUserName());
				MobileControllerUtils
						.setUserAllInfoToSession(mobileUserAllInfo);
			}
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
			mobileUserAllInfoResult.setData(mobileUserAllInfoVO);
		}
		return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
	}

	@ResponseBody
	@RequestMapping("/userImageUpload")
	public String userImageUpload(
			MobileUserAllInfoParams mobileUserAllInfoParams) {
		MobileUserAllInfoResult mobileUserAllInfoResult = new MobileUserAllInfoResult();
		if (!StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
				.getPhone())
				|| !StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
						.getPhoneCode())
				|| null == mobileUserAllInfoParams.getUserImage()) {
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
			return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
		}
		if (!MobileControllerUtils.checkUserLoginStatus(
				mobileUserAllInfoParams.getPhone(),
				mobileUserAllInfoParams.getPhoneCode())) {
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getIndex()));
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getName());
			return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
		}

		String filePath = null;
		try {
			filePath = FileUtil.uploadFile(mobileUserAllInfoParams
					.getUserImage());
		} catch (IOException e) {
			return null;
		}
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		Long id = MobileControllerUtils
				.getUserIdFromSession(mobileUserAllInfoParams.getPhone());
		if (null != id && id > 0) {
			mobileUserAllInfo.setUserId(id);
			mobileUserAllInfo.setImageFilePath(filePath);
			mobileUserAllInfoService.updateUserImage(mobileUserAllInfo);
			mobileUserAllInfoResult.setImagePath("upload/"+filePath);
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
		} else {
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getIndex()));
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getName());
		}
		return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
	}

	@ResponseBody
	@RequestMapping("/changePassword")
	public String changePassword(MobileUserAllInfoParams mobileUserAllInfoParams) {
		MobileUserAllInfoResult mobileUserAllInfoResult = new MobileUserAllInfoResult();
		if (StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
						.getPhoneCode())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
						.getOldPassword())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAllInfoParams
						.getNewPassword())) {
			if (!MobileControllerUtils.checkUserLoginStatus(
					mobileUserAllInfoParams.getPhone(),
					mobileUserAllInfoParams.getPhoneCode())) {
				mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getIndex()));
				mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getName());
				return JsonConvert.getInstance()
						.toJson(mobileUserAllInfoResult);
			}
			MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
			Long id = MobileControllerUtils
					.getUserIdFromSession(mobileUserAllInfoParams.getPhone());
			if (null != id && id > 0) {
				mobileUserAllInfo.setUserId(id);
				mobileUserAllInfo.setOldPassword(mobileUserAllInfoParams
						.getOldPassword());
				mobileUserAllInfo.setNewPassword(mobileUserAllInfoParams
						.getNewPassword());
				if (mobileUserAllInfoService.changePassword(mobileUserAllInfo) > 0) {
					mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
					mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
				} else {
					mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.UNSUCCESS.getName());
					mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.UNSUCCESS.getIndex()));
				}
			} else {
				mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getName());
				mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN.getIndex()));
			}
		} else {
			mobileUserAllInfoResult.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getName());
			mobileUserAllInfoResult.setResultCode(String.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER.getIndex()));
		}
		return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
	}

}
