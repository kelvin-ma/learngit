package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.GoldPrice;
import com.csj.gold.service.GoldPriceService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/goldPrice")   
public class GoldPriceController {
	
	private int pageSize = 10;

	@Resource
	GoldPriceService goldPriceService = null;
	
	@RequestMapping("/add")
	public String add(@Param("goldPrice") GoldPrice goldPrice) {
		goldPriceService.add(goldPrice);
		return null;
	}
	
	@RequestMapping("/update")
	public String update(@Param("goldPrice") GoldPrice goldPrice) {
		goldPriceService.update(goldPrice);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("goldPrice") GoldPrice goldPrice) {
		goldPriceService.delete(goldPrice);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("goldPrice") GoldPrice goldPrice) {
		goldPriceService.forbidden(goldPrice);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("goldPrice") GoldPrice goldPrice,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		goldPriceService.searchByParameters(page,goldPrice);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("goldPrice") GoldPrice goldPrice) {
		goldPriceService.searchByPrimaryKey(goldPrice);
		return null;
	}

}
