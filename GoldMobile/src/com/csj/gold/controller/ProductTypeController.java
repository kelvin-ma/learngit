package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.ProductType;
import com.csj.gold.service.ProductTypeService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {
	
	private int pageSize = 10;

	@Resource
	ProductTypeService productTypeService = null;

	@RequestMapping("/add")
	public String add(@Param("productType") ProductType productType) {
		productTypeService.add(productType);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("productType") ProductType productType) {
		productTypeService.update(productType);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("productType") ProductType productType) {
		productTypeService.delete(productType);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("productType") ProductType productType) {
		productTypeService.forbidden(productType);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("productType") ProductType productType,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		productTypeService.searchByParameters(page,productType);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("productType") ProductType productType) {
		productTypeService.searchByPrimaryKey(productType);
		return null;
	}

}
