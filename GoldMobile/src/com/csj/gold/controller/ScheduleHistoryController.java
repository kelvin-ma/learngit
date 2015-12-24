package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.ScheduleHistory;
import com.csj.gold.service.ScheduleHistoryService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/scheduleHistory")
public class ScheduleHistoryController {
	
	private int pageSize = 10;

	@Resource
	ScheduleHistoryService scheduleHistoryService = null;

	@RequestMapping("/add")
	public String add(@Param("scheduleHistory") ScheduleHistory scheduleHistory) {
		scheduleHistoryService.add(scheduleHistory);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("scheduleHistory") ScheduleHistory scheduleHistory) {
		scheduleHistoryService.update(scheduleHistory);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("scheduleHistory") ScheduleHistory scheduleHistory) {
		scheduleHistoryService.delete(scheduleHistory);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("scheduleHistory") ScheduleHistory scheduleHistory) {
		scheduleHistoryService.forbidden(scheduleHistory);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("scheduleHistory") ScheduleHistory scheduleHistory,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		scheduleHistoryService.searchByParameters(page,scheduleHistory);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("scheduleHistory") ScheduleHistory scheduleHistory) {
		scheduleHistoryService.searchByPrimaryKey(scheduleHistory);
		return null;
	}

}
