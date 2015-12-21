package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.SysDictionaryType;
import com.csj.gold.service.SysDictionaryTypeService;

@Controller
@RequestMapping("/sysDictionaryType")
public class SysDictionaryTypeController {

	@Resource
	SysDictionaryTypeService sysDictionaryTypeService = null;

	@RequestMapping("/add")
	public String add(
			@Param("sysDictionaryType") SysDictionaryType sysDictionaryType) {
		sysDictionaryTypeService.add(sysDictionaryType);
		return null;
	}

	@RequestMapping("/update")
	public String update(
			@Param("sysDictionaryType") SysDictionaryType sysDictionaryType) {
		sysDictionaryTypeService.update(sysDictionaryType);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(
			@Param("sysDictionaryType") SysDictionaryType sysDictionaryType) {
		sysDictionaryTypeService.delete(sysDictionaryType);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(
			@Param("sysDictionaryType") SysDictionaryType sysDictionaryType) {
		sysDictionaryTypeService.forbidden(sysDictionaryType);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("sysDictionaryType") SysDictionaryType sysDictionaryType) {
		sysDictionaryTypeService.searchByParameters(sysDictionaryType);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("sysDictionaryType") SysDictionaryType sysDictionaryType) {
		sysDictionaryTypeService.searchByPrimaryKey(sysDictionaryType);
		return null;
	}

}
