package com.csj.gold.mobile.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.vo.MobileUserAddressParams;
import com.csj.gold.mobile.vo.MobileUserAllInfoParams;
import com.csj.gold.mobile.vo.MobileUserAllInfoResult;
import com.csj.gold.mobile.vo.MobileUserAllInfoVO;
import com.csj.gold.model.UserInfo;
import com.csj.gold.model.bean.MobileUserAllInfo;
import com.csj.gold.service.MobileUserAllInfoService;
import com.csj.gold.utils.file.FileUtil;
import com.csj.gold.utils.json.JsonConvert;
@Controller
@RequestMapping("/user")
public class MobileUserAllInfoController {
	
	@Resource
	private MobileUserAllInfoService mobileUserAllInfoService;
	
	@RequestMapping("/mypage")  
    public String mypage(MobileUserAddressParams mobileUserAllInfoParams){
		MobileUserAllInfoResult mobileUserAllInfoResult = new MobileUserAllInfoResult();
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		MobileUserAllInfoVO  mobileUserAllInfoVO= new MobileUserAllInfoVO();
		if(null!=mobileUserAllInfoParams.getUserId()){
			mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
			mobileUserAllInfo = mobileUserAllInfoService.searchByUserId(mobileUserAllInfo);
			if(null != mobileUserAllInfo){
				mobileUserAllInfoVO.setBankCode(mobileUserAllInfo.getBankCode());
				mobileUserAllInfoVO.setBankName(mobileUserAllInfo.getBankName());
				mobileUserAllInfoVO.setCardNumber(mobileUserAllInfo.getCardNumber());
				mobileUserAllInfoVO.setCertNo(mobileUserAllInfo.getCertNo());
				mobileUserAllInfoVO.setCardId(mobileUserAllInfo.getCardId());
				mobileUserAllInfoVO.setImageFilePath(mobileUserAllInfo.getImageFilePath());
				mobileUserAllInfoVO.setPhone(mobileUserAllInfo.getPhone());
				mobileUserAllInfoVO.setUserId(mobileUserAllInfo.getUserId());
				mobileUserAllInfoVO.setUserName(mobileUserAllInfo.getUserName());
			}
		}
		mobileUserAllInfoResult.setData(mobileUserAllInfoVO);
		return JsonConvert.getInstance().toJson(mobileUserAllInfoResult);
    }
	@RequestMapping("/userIdentification")
	public String userIdentification(MobileUserAllInfoParams mobileUserAllInfoParams){
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
		mobileUserAllInfo.setCertNo(mobileUserAllInfoParams.getCertNo());
		mobileUserAllInfo.setUserName(mobileUserAllInfoParams.getUserName());
		mobileUserAllInfoService.userIdentification(mobileUserAllInfo);
		//判断是否验证成功
		mobileUserAllInfoService.updateUserInfo(mobileUserAllInfo);
		return null;
	}
	
	@RequestMapping("/userImageUpload")
	public String userImageUpload(MobileUserAllInfoParams mobileUserAllInfoParams){
		String filePath = null;
		if(null!=mobileUserAllInfoParams.getUserImage()){
			try {
				filePath = FileUtil.uploadFile(mobileUserAllInfoParams.getUserImage());
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
	
	@RequestMapping("/changePassword")
	public String changePassword(MobileUserAllInfoParams mobileUserAllInfoParams){
		MobileUserAllInfo mobileUserAllInfo = new MobileUserAllInfo();
		mobileUserAllInfo.setUserId(mobileUserAllInfoParams.getUserId());
		mobileUserAllInfo.setOldPassword(mobileUserAllInfoParams.getOldPassword());
		mobileUserAllInfo.setNewPassword(mobileUserAllInfoParams.getNewPassword());
		mobileUserAllInfoService.changePassword(mobileUserAllInfo);
		return null;
	}
	
}
