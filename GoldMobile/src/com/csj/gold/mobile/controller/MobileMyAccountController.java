package com.csj.gold.mobile.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.vo.MobileGoldPriceResult;
import com.csj.gold.mobile.vo.MobileGoldPriceVO;
import com.csj.gold.model.GoldPrice;
import com.csj.gold.service.MobileMyAccountService;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping("/myaccount")
public class MobileMyAccountController {
	private static Logger logger = Logger.getLogger(MobileMyAccountController.class);

	@Resource
	private  MobileMyAccountService mobileMyAccountService;
	

}
