package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysAccount;
import com.csj.gold.service.SysAccountService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysAccount")
public class SysAccountController {
	
	private int pageSize = 10;

	@Resource
	SysAccountService sysAccountService = null;

	@RequestMapping("/add")
	public String add(@Param("sysAccount") SysAccount sysAccount) {
		sysAccountService.add(sysAccount);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysAccount") SysAccount sysAccount) {
		sysAccountService.update(sysAccount);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysAccount") SysAccount sysAccount) {
		sysAccountService.delete(sysAccount);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysAccount") SysAccount sysAccount) {
		sysAccountService.forbidden(sysAccount);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysAccount") SysAccount sysAccount,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysAccountService.searchByParameters(page,sysAccount);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysAccount") SysAccount sysAccount) {
		sysAccountService.searchByPrimaryKey(sysAccount);
		return null;
	}

}
