package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.PushMessageHistory;
import com.csj.gold.service.PushMessageHistoryService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/pushMessageHistory")
public class PushMessageHistoryController {
	
	private int pageSize = 10;

	@Resource
	PushMessageHistoryService pushMessageHistoryService = null;

	@RequestMapping("/add")
	public String add(@Param("pushMessageHistory") PushMessageHistory pushMessageHistory) {
		pushMessageHistoryService.add(pushMessageHistory);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("pushMessageHistory") PushMessageHistory pushMessageHistory) {
		pushMessageHistoryService.update(pushMessageHistory);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("pushMessageHistory") PushMessageHistory pushMessageHistory) {
		pushMessageHistoryService.delete(pushMessageHistory);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("pushMessageHistory") PushMessageHistory pushMessageHistory) {
		pushMessageHistoryService.forbidden(pushMessageHistory);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("pushMessageHistory") PushMessageHistory pushMessageHistory,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		pushMessageHistoryService.searchByParameters(page,pushMessageHistory);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("pushMessageHistory") PushMessageHistory pushMessageHistory) {
		pushMessageHistoryService.searchByPrimaryKey(pushMessageHistory);
		return null;
	}

}
