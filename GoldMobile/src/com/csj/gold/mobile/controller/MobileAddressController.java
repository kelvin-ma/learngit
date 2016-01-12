package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.common.MobileStateConstants;
import com.csj.gold.mobile.vo.MobileUserAddressParams;
import com.csj.gold.mobile.vo.MobileUserAddressResult;
import com.csj.gold.mobile.vo.MobileUserAddressVO;
import com.csj.gold.model.UserAddress;
import com.csj.gold.service.MobileUserAddressService;
import com.csj.gold.utils.StringUtils;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping(value = "/address", produces = "text/html;charset=UTF-8")
public class MobileAddressController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger
			.getLogger(MobileAddressController.class);

	@Resource
	private MobileUserAddressService mobileUserAddressService;

	@ResponseBody
	@RequestMapping("/searchAllAddress")
	public String searchByUserId(MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getPhoneCode())) {
			if (!MobileControllerUtils.checkUserLoginStatus(
					mobileUserAddressParams.getPhone(),
					mobileUserAddressParams.getPhoneCode())) {
				mobileUserAddressResult
						.setResultCode(String
								.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
										.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
								.getName());
				return JsonConvert.getInstance()
						.toJson(mobileUserAddressResult);
			}
			List<MobileUserAddressVO> resultAddressList = null;
			UserAddress userAddress = new UserAddress();
			userAddress.setUserId(MobileControllerUtils
					.getMobileUserAllInfoFromSession(
							mobileUserAddressParams.getPhone()).getUserId());
			List<UserAddress> addressListTemp = mobileUserAddressService
					.searchByUserId(userAddress);
			resultAddressList = traceToMobileUserAddressVOList(addressListTemp);
			if (resultAddressList.size() == 0) {
				mobileUserAddressResult.setResultCode(String
						.valueOf(MobileStateConstants.MobileConstants.NO_DATA
								.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileConstants.NO_DATA
								.getName());
			} else {
				mobileUserAddressResult.setResultCode(String
						.valueOf(MobileStateConstants.MobileConstants.SUCCESS
								.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS
								.getName());
			}
			mobileUserAddressResult.setData(resultAddressList);
		} else {
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
									.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
							.getName());
		}
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	@ResponseBody
	@RequestMapping("/changeMainAddress")
	public String changeMainAddress(
			MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getPhoneCode())
				&& null != mobileUserAddressParams.getAddressId()) {
			if (!MobileControllerUtils.checkUserLoginStatus(
					mobileUserAddressParams.getPhone(),
					mobileUserAddressParams.getPhoneCode())) {
				mobileUserAddressResult
						.setResultCode(String
								.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
										.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
								.getName());
				return JsonConvert.getInstance()
						.toJson(mobileUserAddressResult);
			}
			List<MobileUserAddressVO> resutlAddressList = new ArrayList<MobileUserAddressVO>();
			UserAddress userAddress = new UserAddress();
			userAddress.setUserId(MobileControllerUtils
					.getMobileUserAllInfoFromSession(
							mobileUserAddressParams.getPhone()).getUserId());
			userAddress.setId(mobileUserAddressParams.getAddressId());
			if (mobileUserAddressService.changeMainAddress(userAddress) == 0) {
				mobileUserAddressResult
						.setResultCode(String
								.valueOf(MobileStateConstants.MobileErrorConstants.UPDATE_FAULE
										.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileErrorConstants.UPDATE_FAULE
								.getName());
				return JsonConvert.getInstance()
						.toJson(mobileUserAddressResult);
			}
			List<UserAddress> addressListTemp = mobileUserAddressService
					.searchByUserId(userAddress);
			resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
			mobileUserAddressResult.setData(resutlAddressList);
		} else {
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.SHORT_PARAMETER
									.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.SHORT_PARAMETER
							.getName());
		}
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	@ResponseBody
	@RequestMapping("/addAddress")
	public String addAddress(MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
				.getPhone())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getPhoneCode())
				&& StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getAddress())) {
			if (!MobileControllerUtils.checkUserLoginStatus(
					mobileUserAddressParams.getPhone(),
					mobileUserAddressParams.getPhoneCode())) {
				mobileUserAddressResult
						.setResultCode(String
								.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
										.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
								.getName());
				return JsonConvert.getInstance()
						.toJson(mobileUserAddressResult);
			}
			if (!StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
					.getAddress())
					|| !StringUtils
							.checkStringNullAndEmpty(mobileUserAddressParams
									.getConsignee())
					|| !StringUtils
							.checkStringNullAndEmpty(mobileUserAddressParams
									.getConsigneePhone())
					|| !StringUtils
							.checkStringNullAndEmpty(mobileUserAddressParams
									.getCity())
					|| !StringUtils
							.checkStringNullAndEmpty(mobileUserAddressParams
									.getProvince())
					|| !StringUtils
							.checkStringNullAndEmpty(mobileUserAddressParams
									.getDistrict())
					|| null == mobileUserAddressParams.getIsMain()) {
				mobileUserAddressResult
						.setResultCode(String
								.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
										.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
								.getName());
				return JsonConvert.getInstance()
						.toJson(mobileUserAddressResult);
			}
			List<MobileUserAddressVO> resutlAddressList = null;

			UserAddress userAddress = new UserAddress();
			userAddress.setUserId(MobileControllerUtils
					.getMobileUserAllInfoFromSession(
							mobileUserAddressParams.getPhone()).getUserId());
			System.out.println("Address:"
					+ MobileControllerUtils.getMobileUserAllInfoFromSession(
							mobileUserAddressParams.getPhone()).getUserId());
			userAddress.setAddress(mobileUserAddressParams.getAddress());
			userAddress.setConsignee(mobileUserAddressParams.getConsignee());
			userAddress.setConsigneePhone(mobileUserAddressParams
					.getConsigneePhone());
			userAddress.setCity(mobileUserAddressParams.getCity());
			userAddress.setPostCode(mobileUserAddressParams.getPostCode());
			userAddress.setProvince(mobileUserAddressParams.getProvince());
			userAddress.setDistrict(mobileUserAddressParams.getDistrict());
			userAddress.setIsDel(0);
			userAddress.setIsForbidden(0);
			userAddress.setIsMain(0);
			userAddress.setVersion(0);
			int result = mobileUserAddressService.addAddress(userAddress);
			if (result == 1) {
				if (mobileUserAddressParams.getIsMain() == 1) {
					mobileUserAddressService.changeMainAddress(userAddress);
				}
				List<UserAddress> addressListTemp = mobileUserAddressService
						.searchByUserId(userAddress);
				resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
				if (null == resutlAddressList) {
					mobileUserAddressResult
							.setResultCode(String
									.valueOf(MobileStateConstants.MobileConstants.NO_DATA
											.getIndex()));
					mobileUserAddressResult
							.setResultDesc(MobileStateConstants.MobileConstants.NO_DATA
									.getName());
				} else {
					mobileUserAddressResult
							.setResultCode(String
									.valueOf(MobileStateConstants.MobileConstants.SUCCESS
											.getIndex()));
					mobileUserAddressResult
							.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS
									.getName());
					mobileUserAddressResult.setData(resutlAddressList);
				}
			} else {
				mobileUserAddressResult
						.setResultCode(String
								.valueOf(MobileStateConstants.MobileErrorConstants.UNSUCCESS
										.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileErrorConstants.UNSUCCESS
								.getName());
			}
		} else {
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
									.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
							.getName());
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
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
							.getName());
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
									.getIndex()));
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		if (!StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
				.getAddress())
				|| !StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getConsignee())
				|| !StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getConsigneePhone())
				|| !StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getCity())
				|| !StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getProvince())
				|| !StringUtils.checkStringNullAndEmpty(mobileUserAddressParams
						.getDistrict())
				|| null == mobileUserAddressParams.getIsMain()) {
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
									.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
							.getName());
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		UserAddress userAddressTemp = mobileUserAddressService
				.searchById(mobileUserAddressParams.getAddressId());
		// if (null != userAddressTemp
		// && userAddressTemp.getVersion() == mobileUserAddressParams
		// .getVersion()) {
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(MobileControllerUtils
				.getMobileUserAllInfoFromSession(
						mobileUserAddressParams.getPhone()).getUserId());
		userAddress.setId(mobileUserAddressParams.getAddressId());
		userAddress.setAddress(mobileUserAddressParams.getAddress());
		userAddress.setConsignee(mobileUserAddressParams.getConsignee());
		userAddress.setConsigneePhone(mobileUserAddressParams
				.getConsigneePhone());
		userAddress.setCity(mobileUserAddressParams.getCity());
		userAddress.setPostCode(mobileUserAddressParams.getPostCode());
		userAddress.setProvince(mobileUserAddressParams.getProvince());
		userAddress.setDistrict(mobileUserAddressParams.getDistrict());
		int result = mobileUserAddressService.updateAddress(userAddress);
		if (result == 1) {
			if (mobileUserAddressParams.getIsMain() == 1) {
				result = mobileUserAddressService
						.changeMainAddress(userAddress);
			}
			List<UserAddress> addressListTemp = mobileUserAddressService
					.searchByUserId(userAddress);
			resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
			if (resutlAddressList.size() == 0) {
				mobileUserAddressResult.setResultCode(String
						.valueOf(MobileStateConstants.MobileConstants.NO_DATA
								.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileConstants.NO_DATA
								.getName());
			} else {
				mobileUserAddressResult.setData(resutlAddressList);
				mobileUserAddressResult.setResultCode(String
						.valueOf(MobileStateConstants.MobileConstants.SUCCESS
								.getIndex()));
				mobileUserAddressResult
						.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS
								.getName());
			}
		} else {
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.UNSUCCESS
									.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.UNSUCCESS
							.getName());
		}
		// }
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}

	@ResponseBody
	@RequestMapping("/deleteAddress")
	public String deleteAddress(MobileUserAddressParams mobileUserAddressParams) {
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		if (!MobileControllerUtils.checkUserLoginStatus(
				mobileUserAddressParams.getPhone(),
				mobileUserAddressParams.getPhoneCode())) {
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
							.getName());
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.NOT_LOGIN
									.getIndex()));
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		if (null == mobileUserAddressParams.getAddressId()) {
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
									.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.WRONG_PARAMETER
							.getName());
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(MobileControllerUtils
				.getMobileUserAllInfoFromSession(
						mobileUserAddressParams.getPhone()).getUserId());
		userAddress.setId(mobileUserAddressParams.getAddressId());
		userAddress.setIsDel(1);
		userAddress.setIsMain(0);
		int result = mobileUserAddressService.deleteAddress(userAddress);
		if (result == 0) {
			mobileUserAddressResult
					.setResultCode(String
							.valueOf(MobileStateConstants.MobileErrorConstants.UNSUCCESS
									.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileErrorConstants.UNSUCCESS
							.getName());
			return JsonConvert.getInstance().toJson(mobileUserAddressResult);
		}
		List<UserAddress> addressListTemp = mobileUserAddressService
				.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if (resutlAddressList.size() == 0) {
			mobileUserAddressResult.setResultCode(String
					.valueOf(MobileStateConstants.MobileConstants.NO_DATA
							.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileConstants.NO_DATA
							.getName());
		} else {
			mobileUserAddressResult.setResultCode(String
					.valueOf(MobileStateConstants.MobileConstants.SUCCESS
							.getIndex()));
			mobileUserAddressResult
					.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS
							.getName());
			mobileUserAddressResult.setData(resutlAddressList);
		}
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
				mobileUserAddressVO.setProvince(temp.getProvince());
				mobileUserAddressVO.setCity(temp.getCity());
				mobileUserAddressVO.setDistrict(temp.getDistrict());
				mobileUserAddressVO.setConsignee(temp.getConsignee());
				mobileUserAddressVO.setIsMain(temp.getIsMain());
				mobileUserAddressVO.setConsigneePhone(temp.getConsigneePhone());
				mobileUserAddressVO.setPostCode(temp.getPostCode());
				mobileUserAddressVO.setId(temp.getId());
				mobileUserAddressVO.setIsMain(temp.getIsMain());
				mobileUserAddressVO.setVersion(temp.getVersion());
				resutlAddressList.add(mobileUserAddressVO);
			}
		}
		return resutlAddressList;
	}

}
