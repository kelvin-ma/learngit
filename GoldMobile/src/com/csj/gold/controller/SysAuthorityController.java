package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysAuthority;
import com.csj.gold.service.SysAuthorityService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysAuthority")
public class SysAuthorityController {
	
	private int pageSize = 10;

	@Resource
	SysAuthorityService sysAuthorityService = null;

	@RequestMapping("/add")
	public String add(@Param("sysAuthority") SysAuthority sysAuthority) {
		sysAuthorityService.add(sysAuthority);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysAuthority") SysAuthority sysAuthority) {
		sysAuthorityService.update(sysAuthority);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysAuthority") SysAuthority sysAuthority) {
		sysAuthorityService.delete(sysAuthority);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysAuthority") SysAuthority sysAuthority) {
		sysAuthorityService.forbidden(sysAuthority);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysAuthority") SysAuthority sysAuthority,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysAuthorityService.searchByParameters(page,sysAuthority);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysAuthority") SysAuthority sysAuthority) {
		sysAuthorityService.searchByPrimaryKey(sysAuthority);
		return null;
	}

}
