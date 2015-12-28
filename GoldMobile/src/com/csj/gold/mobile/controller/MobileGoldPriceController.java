package com.csj.gold.mobile.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.vo.MobileGoldPriceParams;
import com.csj.gold.mobile.vo.MobileGoldPriceResult;
import com.csj.gold.mobile.vo.MobileGoldPriceVO;
import com.csj.gold.model.GoldPrice;
import com.csj.gold.service.GoldPriceService;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping("/goldprice")
public class MobileGoldPriceController {
	private static Logger logger = Logger.getLogger(MobileGoldPriceController.class);

	@Resource
	private GoldPriceService goldPriceService;
	
	@ResponseBody
	@RequestMapping("/price")
	public String login(MobileGoldPriceParams mobileGoldPriceParams) {
		MobileGoldPriceResult mobileGoldPriceResult = new MobileGoldPriceResult();
		MobileGoldPriceVO mobileGoldPriceVO = new MobileGoldPriceVO();
		GoldPrice goldPrice = goldPriceService.searchRecentGoldPrice();
		mobileGoldPriceVO.setGoldPrice(String.valueOf(goldPrice.getGoldPrice()));
		return JsonConvert.getInstance().toJson(mobileGoldPriceResult);
	}

}
