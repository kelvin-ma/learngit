package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysAccountTransactions;
import com.csj.gold.service.SysAccountTransactionsService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysAccountTransactions")
public class SysAccountTransactionsController {
	
	private int pageSize = 10;

	@Resource
	SysAccountTransactionsService sysAccountTransactionsService = null;

	@RequestMapping("/add")
	public String add(@Param("sysAccountTransactions") SysAccountTransactions sysAccountTransactions) {
		sysAccountTransactionsService.add(sysAccountTransactions);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysAccountTransactions") SysAccountTransactions sysAccountTransactions) {
		sysAccountTransactionsService.update(sysAccountTransactions);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysAccountTransactions") SysAccountTransactions sysAccountTransactions) {
		sysAccountTransactionsService.delete(sysAccountTransactions);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysAccountTransactions") SysAccountTransactions sysAccountTransactions) {
		sysAccountTransactionsService.forbidden(sysAccountTransactions);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysAccountTransactions") SysAccountTransactions sysAccountTransactions,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysAccountTransactionsService.searchByParameters(page,sysAccountTransactions);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysAccountTransactions") SysAccountTransactions sysAccountTransactions) {
		sysAccountTransactionsService.searchByPrimaryKey(sysAccountTransactions);
		return null;
	}

}
