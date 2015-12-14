package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysDictionaryType;
import com.csj.gold.mobile.service.SysDictionaryTypeService;

@Controller
@RequestMapping("/SysDictionaryType")
public class SysDictionaryTypeController {

	private SysDictionaryType sysDictionaryType;

	private List<SysDictionaryType> sysDictionaryTypeList;

	private int result;

	@Resource
	private SysDictionaryTypeService sysDictionaryTypeService;

	@RequestMapping("/index")
	public List<SysDictionaryType> index() {
		sysDictionaryTypeList = sysDictionaryTypeService
				.searchByParameters(sysDictionaryType);
		return sysDictionaryTypeList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysDictionaryTypeService.insert(sysDictionaryType);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysDictionaryTypeService.delete(sysDictionaryType.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysDictionaryTypeService.forbidden(sysDictionaryType.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysDictionaryType = sysDictionaryTypeService
				.searchById(sysDictionaryType.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysDictionaryTypeService.update(sysDictionaryType);
		return "result-jsp";
	}

	public SysDictionaryType getSysDictionaryType() {
		return sysDictionaryType;
	}

	public void setSysDictionaryType(SysDictionaryType sysDictionaryType) {
		this.sysDictionaryType = sysDictionaryType;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysDictionaryType> getSysDictionaryTypeList() {
		return sysDictionaryTypeList;
	}

	public void setSysDictionaryTypeList(
			List<SysDictionaryType> sysDictionaryTypeList) {
		this.sysDictionaryTypeList = sysDictionaryTypeList;
	}
}