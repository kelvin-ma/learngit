package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.ProductPriceInfo;
import com.csj.gold.service.ProductPriceInfoService;
import com.csj.gold.utils.page.Page;

@Controller    
@RequestMapping("/productPriceInfo")
public class ProductPriceInfoController {
	
	private int pageSize = 10;

	@Resource
	ProductPriceInfoService productPriceInfoService = null;

	@RequestMapping("/add")
	public String add(@Param("productPriceInfo") ProductPriceInfo productPriceInfo) {
		productPriceInfoService.add(productPriceInfo);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("productPriceInfo") ProductPriceInfo productPriceInfo) {
		productPriceInfoService.update(productPriceInfo);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("productPriceInfo") ProductPriceInfo productPriceInfo) {
		productPriceInfoService.delete(productPriceInfo);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("productPriceInfo") ProductPriceInfo productPriceInfo) {
		productPriceInfoService.forbidden(productPriceInfo);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("productPriceInfo") ProductPriceInfo productPriceInfo,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		productPriceInfoService.searchByParameters(page,productPriceInfo);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("productPriceInfo") ProductPriceInfo productPriceInfo) {
		productPriceInfoService.searchByPrimaryKey(productPriceInfo);
		return null;
	}

}
