package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysMobileMenu;
import com.csj.gold.mobile.service.SysMobileMenuService;

@Controller
@RequestMapping("/SysMobileMenu")
public class SysMobileMenuController {

	private SysMobileMenu sysMobileMenu;

	private List<SysMobileMenu> sysMobileMenuList;

	private int result;

	@Resource
	private SysMobileMenuService sysMobileMenuService;

	@RequestMapping("/index")
	public List<SysMobileMenu> index() {
		sysMobileMenuList = sysMobileMenuService
				.searchByParameters(sysMobileMenu);
		return sysMobileMenuList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysMobileMenuService.insert(sysMobileMenu);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysMobileMenuService.delete(sysMobileMenu.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysMobileMenuService.forbidden(sysMobileMenu.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysMobileMenu = sysMobileMenuService.searchById(sysMobileMenu.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysMobileMenuService.update(sysMobileMenu);
		return "result-jsp";
	}

	public SysMobileMenu getSysMobileMenu() {
		return sysMobileMenu;
	}

	public void setSysMobileMenu(SysMobileMenu sysMobileMenu) {
		this.sysMobileMenu = sysMobileMenu;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysMobileMenu> getSysMobileMenuList() {
		return sysMobileMenuList;
	}

	public void setSysMobileMenuList(List<SysMobileMenu> sysMobileMenuList) {
		this.sysMobileMenuList = sysMobileMenuList;
	}
}