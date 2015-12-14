package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysMenu;
import com.csj.gold.mobile.service.SysMenuService;

@Controller
@RequestMapping("/SysMenu")
public class SysMenuController {

	private SysMenu sysMenu;

	private List<SysMenu> sysMenuList;

	private int result;

	@Resource
	private SysMenuService sysMenuService;

	@RequestMapping("/index")
	public List<SysMenu> index() {
		sysMenuList = sysMenuService.searchByParameters(sysMenu);
		return sysMenuList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysMenuService.insert(sysMenu);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysMenuService.delete(sysMenu.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysMenuService.forbidden(sysMenu.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysMenu = sysMenuService.searchById(sysMenu.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysMenuService.update(sysMenu);
		return "result-jsp";
	}

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysMenu> getSysMenuList() {
		return sysMenuList;
	}

	public void setSysMenuList(List<SysMenu> sysMenuList) {
		this.sysMenuList = sysMenuList;
	}
}