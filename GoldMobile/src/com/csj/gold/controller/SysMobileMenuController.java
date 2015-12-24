package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysMobileMenu;
import com.csj.gold.service.SysMobileMenuService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysMobileMenu")
public class SysMobileMenuController {
	
	private int pageSize = 10;

	@Resource
	SysMobileMenuService sysMobileMenuService = null;

	@RequestMapping("/add")
	public String add(@Param("sysMobileMenu") SysMobileMenu sysMobileMenu) {
		sysMobileMenuService.add(sysMobileMenu);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysMobileMenu") SysMobileMenu sysMobileMenu) {
		sysMobileMenuService.update(sysMobileMenu);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysMobileMenu") SysMobileMenu sysMobileMenu) {
		sysMobileMenuService.delete(sysMobileMenu);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysMobileMenu") SysMobileMenu sysMobileMenu) {
		sysMobileMenuService.forbidden(sysMobileMenu);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysMobileMenu") SysMobileMenu sysMobileMenu,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysMobileMenuService.searchByParameters(page,sysMobileMenu);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysMobileMenu") SysMobileMenu sysMobileMenu) {
		sysMobileMenuService.searchByPrimaryKey(sysMobileMenu);
		return null;
	}

}
