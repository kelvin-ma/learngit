package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysMenu;
import com.csj.gold.service.SysMenuService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
	
	private int pageSize = 10;

	@Resource
	SysMenuService sysMenuService = null;

	@RequestMapping("/add")
	public String add(@Param("sysMenu") SysMenu sysMenu) {
		sysMenuService.add(sysMenu);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysMenu") SysMenu sysMenu) {
		sysMenuService.update(sysMenu);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysMenu") SysMenu sysMenu) {
		sysMenuService.delete(sysMenu);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysMenu") SysMenu sysMenu) {
		sysMenuService.forbidden(sysMenu);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysMenu") SysMenu sysMenu,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysMenuService.searchByParameters(page,sysMenu);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysMenu") SysMenu sysMenu) {
		sysMenuService.searchByPrimaryKey(sysMenu);
		return null;
	}

}
