package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.RoleAuthority;
import com.csj.gold.service.RoleAuthorityService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/roleAuthority")
public class RoleAuthorityController {
	
	private int pageSize = 10;

	@Resource
	RoleAuthorityService roleAuthorityService = null;

	@RequestMapping("/add")
	public String add(@Param("roleAuthority") RoleAuthority roleAuthority) {
		roleAuthorityService.add(roleAuthority);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("roleAuthority") RoleAuthority roleAuthority) {
		roleAuthorityService.update(roleAuthority);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("roleAuthority") RoleAuthority roleAuthority) {
		roleAuthorityService.delete(roleAuthority);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("roleAuthority") RoleAuthority roleAuthority) {
		roleAuthorityService.forbidden(roleAuthority);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("roleAuthority") RoleAuthority roleAuthority,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		roleAuthorityService.searchByParameters(page,roleAuthority);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("roleAuthority") RoleAuthority roleAuthority) {
		roleAuthorityService.searchByPrimaryKey(roleAuthority);
		return null;
	}

}
