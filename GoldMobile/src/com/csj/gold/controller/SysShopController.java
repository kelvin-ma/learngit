package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysShop;
import com.csj.gold.service.SysShopService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysShop")
public class SysShopController {
	
	private int pageSize = 10;

	@Resource
	SysShopService sysShopService = null;

	@RequestMapping("/add")
	public String add(@Param("sysShop") SysShop sysShop) {
		sysShopService.add(sysShop);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysShop") SysShop sysShop) {
		sysShopService.update(sysShop);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysShop") SysShop sysShop) {
		sysShopService.delete(sysShop);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysShop") SysShop sysShop) {
		sysShopService.forbidden(sysShop);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysShop") SysShop sysShop,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysShopService.searchByParameters(page,sysShop);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysShop") SysShop sysShop) {
		sysShopService.searchByPrimaryKey(sysShop);
		return null;
	}

}
