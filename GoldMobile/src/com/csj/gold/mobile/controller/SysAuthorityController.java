package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysAuthority;
import com.csj.gold.mobile.service.SysAuthorityService;

@Controller
@RequestMapping("/SysAuthority")
public class SysAuthorityController {

	private SysAuthority sysAuthority;

	private List<SysAuthority> sysAuthorityList;

	private int result;

	@Resource
	private SysAuthorityService sysAuthorityService;

	@RequestMapping("/index")
	public List<SysAuthority> index() {
		sysAuthorityList = sysAuthorityService.searchByParameters(sysAuthority);
		return sysAuthorityList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysAuthorityService.insert(sysAuthority);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysAuthorityService.delete(sysAuthority.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysAuthorityService.forbidden(sysAuthority.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysAuthority = sysAuthorityService.searchById(sysAuthority.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysAuthorityService.update(sysAuthority);
		return "result-jsp";
	}

	public SysAuthority getSysAuthority() {
		return sysAuthority;
	}

	public void setSysAuthority(SysAuthority sysAuthority) {
		this.sysAuthority = sysAuthority;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysAuthority> getSysAuthorityList() {
		return sysAuthorityList;
	}

	public void setSysAuthorityList(List<SysAuthority> sysAuthorityList) {
		this.sysAuthorityList = sysAuthorityList;
	}

}