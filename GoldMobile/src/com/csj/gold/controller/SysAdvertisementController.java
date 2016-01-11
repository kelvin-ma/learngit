package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysAdvertisement;
import com.csj.gold.service.SysAdvertisementService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysAdvertisement")
public class SysAdvertisementController {
	
	private int pageSize = 10;

	@Resource
	SysAdvertisementService sysAdvertisementService = null;

	@RequestMapping("/add")
	public String add(@Param("sysAdvertisement") SysAdvertisement sysAdvertisement) {
		sysAdvertisementService.add(sysAdvertisement);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysAdvertisement") SysAdvertisement sysAdvertisement) {
		sysAdvertisementService.update(sysAdvertisement);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysAdvertisement") SysAdvertisement sysAdvertisement) {
		sysAdvertisementService.delete(sysAdvertisement);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysAdvertisement") SysAdvertisement sysAdvertisement) {
		sysAdvertisementService.forbidden(sysAdvertisement);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysAdvertisement") SysAdvertisement sysAdvertisement,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysAdvertisementService.searchByParameters(page,sysAdvertisement);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysAdvertisement") SysAdvertisement sysAdvertisement) {
		sysAdvertisementService.searchByPrimaryKey(sysAdvertisement);
		return null;
	}

}
