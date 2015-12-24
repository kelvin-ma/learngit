package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysContact;
import com.csj.gold.service.SysContactService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysContact")
public class SysContactController {
	
	private int pageSize = 10;

	@Resource
	SysContactService sysContactService = null;

	@RequestMapping("/add")
	public String add(@Param("sysContact") SysContact sysContact) {
		sysContactService.add(sysContact);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysContact") SysContact sysContact) {
		sysContactService.update(sysContact);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysContact") SysContact sysContact) {
		sysContactService.delete(sysContact);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysContact") SysContact sysContact) {
		sysContactService.forbidden(sysContact);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysContact") SysContact sysContact,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysContactService.searchByParameters(page,sysContact);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysContact") SysContact sysContact) {
		sysContactService.searchByPrimaryKey(sysContact);
		return null;
	}

}
