package com.csj.gold.mobile.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.annotation.InterfaceEnum;
import com.csj.gold.mobile.vo.MobileMessageCodeParams;
import com.csj.gold.mobile.vo.MobileMessageCodeResult;
import com.csj.gold.model.bean.MobileUserRegister;
import com.csj.gold.service.MobileUserRegisterService;
import com.csj.gold.utils.StringUtils;
import com.csj.gold.utils.json.JsonConvert;
import com.csj.gold.utils.sms.SendMessage;
import com.csj.gold.utils.sms.SendMessageManage;
import com.csj.gold.utils.sms.SendStateEnum;

@Controller
@RequestMapping("/messageCode")
public class MobileMessageCodeController {

	public static String CHECK_REGISTER_CODE = "checkRegisterMessageCode";

	public static String CHECK_FORGET_PASSWORD_CODE = "checkForgetPasswordMessageCode";

	@SuppressWarnings("unused")
	private static Logger logger = Logger
			.getLogger(MobileMessageCodeController.class);

	@Resource
	private MobileUserRegisterService mobileUserRegisterService;

	@ResponseBody
	@RequestMapping("/sendPhoneNumber")
	public String sendPhonNumber(MobileMessageCodeParams mobileMessageCodeParams) {
		MobileMessageCodeResult mobileMessageCodeResult = new MobileMessageCodeResult();
		if (!StringUtils.checkStringNullAndEmpty(mobileMessageCodeParams
				.getTypeCode())
				|| !StringUtils.checkStringNullAndEmpty(mobileMessageCodeParams
						.getPhone())
				|| !StringUtils.checkStringNullAndEmpty(mobileMessageCodeParams
						.getPhoneCode())) {
			mobileMessageCodeResult.setResultCode("3001");
			mobileMessageCodeResult.setResultDesc("No parameter");
			return JsonConvert.getInstance().toJson(mobileMessageCodeResult);
		}
		MobileUserRegister mobileUserRegister = new MobileUserRegister();
		mobileUserRegister.setPhone(mobileMessageCodeParams.getPhone());
		List<MobileUserRegister> userLogin = mobileUserRegisterService
				.searchByUserPhone(mobileUserRegister);
		Map<String, Integer> userMap = MobileControllerUtils
				.getUserMessageCodeMapFromCacheMessageCodeMap(mobileMessageCodeParams
						.getPhone());
		if (mobileMessageCodeParams.getTypeCode().equals("register")) {
			if (null != userLogin && userLogin.size() > 0) {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("Exsit Phone!!!!");
				return JsonConvert.getInstance()
						.toJson(mobileMessageCodeResult);
			}
			userMap.put(MobileMessageCodeController.CHECK_REGISTER_CODE, 0);
			SendMessage sendMessage = SendMessageManage.getInstance()
					.sendMessage(mobileMessageCodeParams.getPhone(),
							InterfaceEnum.USER_REGISTER);
			if (SendStateEnum.SEND_SUCCESS == sendMessage.getStateEnum()) {
				mobileMessageCodeResult.setResultCode("2001");
				mobileMessageCodeResult.setResultDesc("Success!!!!!");
			} else {
				Long sec = countDownTime(sendMessage.getNextSendTime());
				mobileMessageCodeResult.setNextSendTime(sec);
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("UnSuccess!!!!!");
			}
		} else if (mobileMessageCodeParams.getTypeCode().equals(
				"forgetPassword")) {
			if (null == userLogin || userLogin.size() == 0) {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("No Phone!!!!");
				return JsonConvert.getInstance()
						.toJson(mobileMessageCodeResult);
			}
			userMap.put(MobileMessageCodeController.CHECK_FORGET_PASSWORD_CODE,
					0);
			SendMessage sendMessage = SendMessageManage.getInstance()
					.sendMessage(mobileMessageCodeParams.getPhone(),
							InterfaceEnum.FORGET_PASSWORD);
			if (SendStateEnum.SEND_SUCCESS == sendMessage.getStateEnum()) {
				Long sec = countDownTime(sendMessage.getNextSendTime());
				mobileMessageCodeResult.setNextSendTime(sec);
				mobileMessageCodeResult.setResultCode("2001");
				mobileMessageCodeResult.setResultDesc("Success!!!!!");
			} else {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("UnSuccess!!!!!");
			}
		} else {
			mobileMessageCodeResult.setResultCode("3001");
			mobileMessageCodeResult.setResultDesc("Wrong parameter");
			return JsonConvert.getInstance().toJson(mobileMessageCodeResult);
		}
		return JsonConvert.getInstance().toJson(mobileMessageCodeResult);
	}

	private Long countDownTime(Long nextSendTime) {
		return (nextSendTime - System.currentTimeMillis()) / 1000;
	}

	@ResponseBody
	@RequestMapping("/checkCode")
	public String checkMessageCode(
			MobileMessageCodeParams mobileMessageCodeParams) {
		MobileMessageCodeResult mobileMessageCodeResult = new MobileMessageCodeResult();
		SendMessage sendMessage = null;
		if (!StringUtils.checkStringNullAndEmpty(mobileMessageCodeParams
				.getTypeCode())
				|| !StringUtils.checkStringNullAndEmpty(mobileMessageCodeParams
						.getPhone())
				|| !StringUtils.checkStringNullAndEmpty(mobileMessageCodeParams
						.getMessageCode())
				|| !StringUtils.checkStringNullAndEmpty(mobileMessageCodeParams
						.getPhoneCode())) {
			mobileMessageCodeResult.setResultCode("3001");
			mobileMessageCodeResult.setResultDesc("No parameter");
			return JsonConvert.getInstance().toJson(mobileMessageCodeResult);
		}
		Map<String, Integer> userMap = MobileControllerUtils
				.getUserMessageCodeMapFromCacheMessageCodeMap(mobileMessageCodeParams
						.getPhone());
		if (mobileMessageCodeParams.getTypeCode().equals("register")) {

			if (null != userMap
					.get(MobileMessageCodeController.CHECK_REGISTER_CODE)
					&& userMap
							.get(MobileMessageCodeController.CHECK_REGISTER_CODE) != 0) {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("Wrong Process");
				return JsonConvert.getInstance()
						.toJson(mobileMessageCodeResult);
			}
			sendMessage = SendMessageManage
					.getInstance()
					.getSendMessageMap()
					.get(mobileMessageCodeParams.getPhone()
							+ InterfaceEnum.USER_REGISTER);
			if (null == sendMessage) {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("No Data");
				return JsonConvert.getInstance()
						.toJson(mobileMessageCodeResult);
			}
			if (sendMessage.getSmsCode().equals(
					mobileMessageCodeParams.getMessageCode())) {
				userMap.put(MobileMessageCodeController.CHECK_REGISTER_CODE, 1);
				mobileMessageCodeResult.setResultCode("2001");
				mobileMessageCodeResult.setResultDesc("Success!!!!!");
			} else {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("UnSuccess!!!!!");
			}
		} else if (mobileMessageCodeParams.getTypeCode().equals(
				"forgetPassword")) {
			if (userMap
					.get(MobileMessageCodeController.CHECK_FORGET_PASSWORD_CODE) != 0) {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("Wrong Process");
				return JsonConvert.getInstance()
						.toJson(mobileMessageCodeResult);
			}
			sendMessage = SendMessageManage
					.getInstance()
					.getSendMessageMap()
					.get(mobileMessageCodeParams.getPhone()
							+ InterfaceEnum.FORGET_PASSWORD);
			if (null == sendMessage) {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("No Data");
				return JsonConvert.getInstance()
						.toJson(mobileMessageCodeResult);
			}
			if (sendMessage.getSmsCode().equals(
					mobileMessageCodeParams.getMessageCode())) {
				userMap.put(
						MobileMessageCodeController.CHECK_FORGET_PASSWORD_CODE,
						1);
				mobileMessageCodeResult.setResultCode("2001");
				mobileMessageCodeResult.setResultDesc("Success!!!!!");
			} else {
				mobileMessageCodeResult.setResultCode("3001");
				mobileMessageCodeResult.setResultDesc("UnSuccess!!!!!");
			}
		}
		return JsonConvert.getInstance().toJson(mobileMessageCodeResult);
	}
}
