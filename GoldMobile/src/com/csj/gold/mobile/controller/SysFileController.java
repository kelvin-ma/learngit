package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.SysFile;
import com.csj.gold.mobile.service.SysFileService;

@Controller
@RequestMapping("/SysFile")
public class SysFileController {

	private SysFile sysFile;

	private List<SysFile> sysFileList;

	private int result;

	@Resource
	private SysFileService sysFileService;

	@RequestMapping("/index")
	public List<SysFile> index() {
		sysFileList = sysFileService.searchByParameters(sysFile);
		return sysFileList;
	}

	@RequestMapping("/add")
	public String add() {
		result = sysFileService.insert(sysFile);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = sysFileService.delete(sysFile.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = sysFileService.forbidden(sysFile.getId());
		return "result-json";
	}

	public String intoUpdate() {
		sysFile = sysFileService.searchById(sysFile.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = sysFileService.update(sysFile);
		return "result-jsp";
	}

	public SysFile getSysFile() {
		return sysFile;
	}

	public void setSysFile(SysFile sysFile) {
		this.sysFile = sysFile;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<SysFile> getSysFileList() {
		return sysFileList;
	}

	public void setSysFileList(List<SysFile> sysFileList) {
		this.sysFileList = sysFileList;
	}
}