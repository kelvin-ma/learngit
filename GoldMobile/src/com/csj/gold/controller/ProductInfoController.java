package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.ProductInfo;
import com.csj.gold.service.ProductInfoService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/productInfo")
public class ProductInfoController {
	
	private int pageSize = 10;

	@Resource
	ProductInfoService productInfoService = null;

	@RequestMapping("/add")
	public String add(@Param("productInfo") ProductInfo productInfo) {
		productInfoService.add(productInfo);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("productInfo") ProductInfo productInfo) {
		productInfoService.update(productInfo);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("productInfo") ProductInfo productInfo) {
		productInfoService.delete(productInfo);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("productInfo") ProductInfo productInfo) {
		productInfoService.forbidden(productInfo);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("productInfo") ProductInfo productInfo,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		productInfoService.searchByParameters(page,productInfo);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("productInfo") ProductInfo productInfo) {
		productInfoService.searchByPrimaryKey(productInfo);
		return null;
	}

}
