package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysFile;
import com.csj.gold.service.SysFileService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysFile")
public class SysFileController {
	
	private int pageSize = 10;

	@Resource
	SysFileService sysFileService = null;

	@RequestMapping("/add")
	public String add(@Param("sysFile") SysFile sysFile) {
		sysFileService.add(sysFile);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysFile") SysFile sysFile) {
		sysFileService.update(sysFile);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysFile") SysFile sysFile) {
		sysFileService.delete(sysFile);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysFile") SysFile sysFile) {
		sysFileService.forbidden(sysFile);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(@Param("sysFile") SysFile sysFile,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysFileService.searchByParameters(page,sysFile);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(@Param("sysFile") SysFile sysFile) {
		sysFileService.searchByPrimaryKey(sysFile);
		return null;
	}

}
