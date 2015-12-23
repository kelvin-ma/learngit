package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysDictionary;
import com.csj.gold.service.SysDictionaryService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/sysDictionary")
public class SysDictionaryController {
	
	private int pageSize = 10;

	@Resource
	SysDictionaryService sysDictionaryService = null;

	@RequestMapping("/add")
	public String add(@Param("sysDictionary") SysDictionary sysDictionary) {
		sysDictionaryService.add(sysDictionary);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("sysDictionary") SysDictionary sysDictionary) {
		sysDictionaryService.update(sysDictionary);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("sysDictionary") SysDictionary sysDictionary) {
		sysDictionaryService.delete(sysDictionary);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("sysDictionary") SysDictionary sysDictionary) {
		sysDictionaryService.forbidden(sysDictionary);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysDictionary") SysDictionary sysDictionary,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		sysDictionaryService.searchByParameters(page,sysDictionary);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysDictionary") SysDictionary sysDictionary) {
		sysDictionaryService.searchByPrimaryKey(sysDictionary);
		return null;
	}

}
