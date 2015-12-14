package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysDictionary;
import com.csj.gold.mobile.service.SysDictionaryService;

@Controller
@RequestMapping("/SysDictionary")
public class SysDictionaryController {

	private SysDictionary sysDictionary;

	private List<SysDictionary> sysDictionaryList;

	private int result;

	@Resource
	private SysDictionaryService sysDictionaryService;

	@RequestMapping("/index")
	public List<SysDictionary> index() {
		sysDictionaryList = sysDictionaryService
				.searchByParameters(sysDictionary);
		return sysDictionaryList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysDictionaryService.insert(sysDictionary);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysDictionaryService.delete(sysDictionary.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysDictionaryService.forbidden(sysDictionary.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysDictionary = sysDictionaryService.searchById(sysDictionary.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysDictionaryService.update(sysDictionary);
		return "result-jsp";
	}

	public SysDictionary getSysDictionary() {
		return sysDictionary;
	}

	public void setSysDictionary(SysDictionary sysDictionary) {
		this.sysDictionary = sysDictionary;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysDictionary> getSysDictionaryList() {
		return sysDictionaryList;
	}

	public void setSysDictionaryList(List<SysDictionary> sysDictionaryList) {
		this.sysDictionaryList = sysDictionaryList;
	}

}