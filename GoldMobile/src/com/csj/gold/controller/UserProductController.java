package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.UserProduct;
import com.csj.gold.service.UserProductService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/userProduct")
public class UserProductController {
	
	private int pageSize = 10;

	@Resource
	UserProductService userProductService = null;

	@RequestMapping("/add")
	public String add(@Param("userProduct") UserProduct userProduct) {
		userProductService.add(userProduct);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("userProduct") UserProduct userProduct) {
		userProductService.update(userProduct);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("userProduct") UserProduct userProduct) {
		userProductService.delete(userProduct);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("userProduct") UserProduct userProduct) {
		userProductService.forbidden(userProduct);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("userProduct") UserProduct userProduct,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		userProductService.searchByParameters(page,userProduct);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("userProduct") UserProduct userProduct) {
		userProductService.searchByPrimaryKey(userProduct);
		return null;
	}

}
