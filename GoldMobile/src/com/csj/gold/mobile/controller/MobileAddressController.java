package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.vo.MobileUserAddressParams;
import com.csj.gold.mobile.vo.MobileUserAddressResult;
import com.csj.gold.mobile.vo.MobileUserAddressVO;
import com.csj.gold.model.UserAddress;
import com.csj.gold.service.MobileUserAddressService;
import com.csj.gold.utils.StringUtils;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping("/address")
public class MobileAddressController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger
			.getLogger(MobileAddressController.class);

	@Resource
	private MobileUserAddressService mobileUserAddressService;

	@ResponseBody
	@RequestMapping("/searchAllAddresss")
	public String searchByUserId(MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (!StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getPhoneCode())) {
			if (!MobileControllerUtils.checkUserLoginStatus(
					mobileUserAddressParams.getPhone(),
					mobileUserAddressParams.getPhoneCode())) {
				mobileUserAddressResult.setResultDesc("Not Login");
				return JsonConvert.getInstance()
						.toJson(mobileUserAddressResult);
			}
			List<MobileUserAddressVO> resutlAddressList = null;
			UserAddress userAddress = new UserAddress();
			userAddress.setUserId(mobileUserAddressParams.getUserId());
			List<UserAddress> addressListTemp = mobileUserAddressService
					.searchByUserId(userAddress);
			resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
			if (null == resutlAddressList) {
				resutlAddressList = new ArrayList<MobileUserAddressVO>();
			}
			mobileUserAddressResult.setData(resutlAddressList);
		} else {
			mobileUserAddressResult.setResultDesc("Wrong parameters");
		}
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	@ResponseBody
	@RequestMapping("/changeMainAddress")
	public String changeMainAddress(
			MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (!StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getPhoneCode())
				&& null != mobileUserAddressParams.getAddressId()) {
			if (!MobileControllerUtils.checkUserLoginStatus(
					mobileUserAddressParams.getPhone(),
					mobileUserAddressParams.getPhoneCode())) {
				mobileUserAddressResult.setResultDesc("Not Login");
				return JsonConvert.getInstance()
						.toJson(mobileUserAddressResult);
			}
			List<MobileUserAddressVO> resutlAddressList = new ArrayList<MobileUserAddressVO>();
			UserAddress userAddress = new UserAddress();
			userAddress.setUserId(mobileUserAddressParams.getUserId());
			userAddress.setId(mobileUserAddressParams.getAddressId());
			if(mobileUserAddressService.changeMainAddress(userAddress)==0){
				mobileUserAddressResult.setResultDesc("Unsuccesss");
				return JsonConvert.getInstance().toJson(mobileUserAddressResult);
			}
			List<UserAddress> addressListTemp = mobileUserAddressService
					.searchByUserId(userAddress);
			resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
			mobileUserAddressResult.setData(resutlAddressList);
		} else {
			mobileUserAddressResult.setResultDesc("Wrong parameters");
		}
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	@ResponseBody
	@RequestMapping("/addAddress")
	public String addAddress(MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (!StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getPhoneCode())&&StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
								.getAddress())) {
		if (!MobileControllerUtils.checkUserLoginStatus(
				mobileUserAddressParams.getPhone(),
				mobileUserAddressParams.getPhoneCode())) {
			mobileUserAddressResult.setResultDesc("Not Login");
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(mobileUserAddressParams.getUserId());
		userAddress.setAddress(mobileUserAddressParams.getAddress());
		userAddress.setConsignee(mobileUserAddressParams.getConsignee());
		userAddress.setPhone(mobileUserAddressParams.getPhone());
		userAddress.setIsDel(0);
		userAddress.setIsForbidden(0);
		userAddress.setIsMain(0);
		mobileUserAddressService.addAddress(userAddress);
		List<UserAddress> addressListTemp = mobileUserAddressService
				.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if (null == resutlAddressList) {
			resutlAddressList = new ArrayList<MobileUserAddressVO>();
		}
		mobileUserAddressResult.setData(resutlAddressList);
		}else{
			
		}
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	@ResponseBody
	@RequestMapping("/updateAddress")
	public String updateAddress(MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (!MobileControllerUtils.checkUserLoginStatus(
				mobileUserAddressParams.getPhone(),
				mobileUserAddressParams.getPhoneCode())) {
			mobileUserAddressResult.setResultDesc("Not Login");
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		UserAddress userAddressTemp = mobileUserAddressService
				.searchById(mobileUserAddressParams.getAddressId());
		if (null != userAddressTemp
				&& userAddressTemp.getVersion() == mobileUserAddressParams
						.getVersion()) {
			List<MobileUserAddressVO> resutlAddressList = null;
			UserAddress userAddress = new UserAddress();
			userAddress.setUserId(mobileUserAddressParams.getUserId());
			userAddress.setId(mobileUserAddressParams.getAddressId());
			userAddress.setAddress(mobileUserAddressParams.getAddress());
			userAddress.setConsignee(mobileUserAddressParams.getConsignee());
			userAddress.setPhone(mobileUserAddressParams.getPhone());
			mobileUserAddressService.updateAddress(userAddress);
			List<UserAddress> addressListTemp = mobileUserAddressService
					.searchByUserId(userAddress);
			resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
			if (null == resutlAddressList) {
				resutlAddressList = new ArrayList<MobileUserAddressVO>();
			}
			mobileUserAddressResult.setData(resutlAddressList);
		}
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	@ResponseBody
	@RequestMapping("/deleteAddress")
	public String deleteAddress(MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (!MobileControllerUtils.checkUserLoginStatus(
				mobileUserAddressParams.getPhone(),
				mobileUserAddressParams.getPhoneCode())) {
			mobileUserAddressResult.setResultDesc("Not Login");
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(mobileUserAddressParams.getUserId());
		userAddress.setId(mobileUserAddressParams.getAddressId());
		userAddress.setIsDel(1);
		userAddress.setIsMain(0);
		mobileUserAddressService.addAddress(userAddress);
		List<UserAddress> addressListTemp = mobileUserAddressService
				.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if (null == resutlAddressList) {
			resutlAddressList = new ArrayList<MobileUserAddressVO>();
		}
		mobileUserAddressResult.setData(resutlAddressList);
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	private List<MobileUserAddressVO> traceToMobileUserAddressVOList(
			List<UserAddress> addressListTemp) {
		List<MobileUserAddressVO> resutlAddressList = new ArrayList<MobileUserAddressVO>();
		MobileUserAddressVO mobileUserAddressVO = null;
		if (null != addressListTemp && addressListTemp.size() > 0) {
			for (UserAddress temp : addressListTemp) {
				mobileUserAddressVO = new MobileUserAddressVO();
				mobileUserAddressVO.setAddress(temp.getAddress());
				mobileUserAddressVO.setConsignee(temp.getConsignee());
				mobileUserAddressVO.setIsMain(temp.getIsMain());
				mobileUserAddressVO.setUserId(temp.getUserId());
				mobileUserAddressVO.setPhone(temp.getPhone());
				mobileUserAddressVO.setId(temp.getId());
				resutlAddressList.add(mobileUserAddressVO);
			}
		}
		return resutlAddressList;
	}

}
