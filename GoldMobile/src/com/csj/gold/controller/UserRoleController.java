package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.UserRole;
import com.csj.gold.service.UserRoleService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {
	
	private int pageSize = 10;

	@Resource
	UserRoleService userRoleService = null;

	@RequestMapping("/add")
	public String add(@Param("userRole") UserRole userRole) {
		userRoleService.add(userRole);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("userRole") UserRole userRole) {
		userRoleService.update(userRole);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("userRole") UserRole userRole) {
		userRoleService.delete(userRole);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("userRole") UserRole userRole) {
		userRoleService.forbidden(userRole);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("userRole") UserRole userRole,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		userRoleService.searchByParameters(page,userRole);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("userRole") UserRole userRole) {
		userRoleService.searchByPrimaryKey(userRole);
		return null;
	}

}
