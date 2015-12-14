package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.RoleAuthority;
import com.csj.gold.mobile.service.RoleAuthorityService;

@Controller
@RequestMapping("/RoleAuthority")
public class RoleAuthorityController {

	private RoleAuthority roleAuthority;

	private List<RoleAuthority> roleAuthorityList;

	private int result;

	@Resource
	private RoleAuthorityService roleAuthorityService;

	@RequestMapping("/index")
	public List<RoleAuthority> index() {
		roleAuthorityList = roleAuthorityService
				.searchByParameters(roleAuthority);
		return roleAuthorityList;
	}

	@RequestMapping("/add")
	public String add() {
		result = roleAuthorityService.insert(roleAuthority);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = roleAuthorityService.delete(roleAuthority.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = roleAuthorityService.forbidden(roleAuthority.getId());
		return "result-json";
	}

	public String intoUpdate() {
		roleAuthority = roleAuthorityService.searchById(roleAuthority.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = roleAuthorityService.update(roleAuthority);
		return "result-jsp";
	}

	public RoleAuthority getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(RoleAuthority roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<RoleAuthority> getRoleAuthorityList() {
		return roleAuthorityList;
	}

	public void setRoleAuthorityList(List<RoleAuthority> roleAuthorityList) {
		this.roleAuthorityList = roleAuthorityList;
	}

}