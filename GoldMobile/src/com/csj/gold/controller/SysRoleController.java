package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysRole;
import com.csj.gold.service.SysRoleService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
	
	private int pageSize = 10;

	@Resource
	SysRoleService sysRoleService = null;

	@RequestMapping("/add")
	public String add(@Param("sysRole") SysRole sysRole) {
		sysRoleService.add(sysRole);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysRole") SysRole sysRole) {
		sysRoleService.update(sysRole);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysRole") SysRole sysRole) {
		sysRoleService.delete(sysRole);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysRole") SysRole sysRole) {
		sysRoleService.forbidden(sysRole);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysRole") SysRole sysRole,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysRoleService.searchByParameters(page,sysRole);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysRole") SysRole sysRole) {
		sysRoleService.searchByPrimaryKey(sysRole);
		return null;
	}

}
