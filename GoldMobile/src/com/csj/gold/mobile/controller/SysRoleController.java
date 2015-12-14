package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysRole;
import com.csj.gold.mobile.service.SysRoleService;

@Controller
@RequestMapping("/SysRole")
public class SysRoleController {

	private SysRole sysRole;

	private List<SysRole> sysRoleList;

	private int result;

	@Resource
	private SysRoleService sysRoleService;

	@RequestMapping("/index")
	public List<SysRole> index() {
		sysRoleList = sysRoleService.searchByParameters(sysRole);
		return sysRoleList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysRoleService.insert(sysRole);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysRoleService.delete(sysRole.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysRoleService.forbidden(sysRole.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysRole = sysRoleService.searchById(sysRole.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysRoleService.update(sysRole);
		return "result-jsp";
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}
}