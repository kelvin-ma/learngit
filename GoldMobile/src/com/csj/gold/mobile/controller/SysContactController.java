package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysContact;
import com.csj.gold.mobile.service.SysContactService;

@Controller
@RequestMapping("/SysContact")
public class SysContactController {

	private SysContact sysContact;

	private List<SysContact> sysContactList;

	private int result;

	@Resource
	private SysContactService sysContactService;

	@RequestMapping("/index")
	public List<SysContact> index() {
		sysContactList = sysContactService.searchByParameters(sysContact);
		return sysContactList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysContactService.insert(sysContact);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysContactService.delete(sysContact.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysContactService.forbidden(sysContact.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysContact = sysContactService.searchById(sysContact.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysContactService.update(sysContact);
		return "result-jsp";
	}

	public SysContact getSysContact() {
		return sysContact;
	}

	public void setSysContact(SysContact sysContact) {
		this.sysContact = sysContact;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysContact> getSysContactList() {
		return sysContactList;
	}

	public void setSysContactList(List<SysContact> sysContactList) {
		this.sysContactList = sysContactList;
	}
}