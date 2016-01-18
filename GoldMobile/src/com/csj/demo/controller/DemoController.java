package com.csj.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.csj.gold.mobile.vo.MobileAdvertisementResult;
import com.csj.gold.model.GoldPrice;
import com.csj.gold.service.GoldPriceService;
import com.csj.gold.utils.json.JsonConvert;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/i")   
public class DemoController {
	
	private int pageSize = 10;

	
	@RequestMapping(value = "/" , produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String add(@Valid User user, BindingResult result) {
		 MobileAdvertisementResult xresult=new MobileAdvertisementResult(); 
		 if(result.hasErrors()) {
			 	xresult.addError(result);
	            return JsonConvert.getInstance().toJson(xresult);  
	     }  
		
		 
		 
		return null;
	}
	
	
}
