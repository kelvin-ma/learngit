package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.ProductInterestInfo;
import com.csj.gold.service.ProductInterestInfoService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/productInterestInfo")
public class ProductInterestInfoController {
	
	private int pageSize = 10;

	@Resource
	ProductInterestInfoService productInterestInfoService = null;

	@RequestMapping("/add")
	public String add(@Param("productInterestInfo") ProductInterestInfo productInterestInfo) {
		productInterestInfoService.add(productInterestInfo);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("productInterestInfo") ProductInterestInfo productInterestInfo) {
		productInterestInfoService.update(productInterestInfo);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("productInterestInfo") ProductInterestInfo productInterestInfo) {
		productInterestInfoService.delete(productInterestInfo);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("productInterestInfo") ProductInterestInfo productInterestInfo) {
		productInterestInfoService.forbidden(productInterestInfo);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("productInterestInfo") ProductInterestInfo productInterestInfo,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		productInterestInfoService.searchByParameters(page,productInterestInfo);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("productInterestInfo") ProductInterestInfo productInterestInfo) {
		productInterestInfoService.searchByPrimaryKey(productInterestInfo);
		return null;
	}

}
