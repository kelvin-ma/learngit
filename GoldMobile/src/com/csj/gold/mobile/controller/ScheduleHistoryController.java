package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.ScheduleHistory;
import com.csj.gold.mobile.service.ScheduleHistoryService;

@Controller
@RequestMapping("/ScheduleHistory")
public class ScheduleHistoryController {

	private ScheduleHistory scheduleHistory;

	private List<ScheduleHistory> scheduleHistoryList;

	private int result;

	@Resource
	private ScheduleHistoryService scheduleHistoryService;

	@RequestMapping("/index")
	public List<ScheduleHistory> index() {
		scheduleHistoryList = scheduleHistoryService
				.searchByParameters(scheduleHistory);
		return scheduleHistoryList;
	}

	@RequestMapping("/add")
	public String add() {
		result = scheduleHistoryService.insert(scheduleHistory);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = scheduleHistoryService.delete(scheduleHistory.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = scheduleHistoryService.forbidden(scheduleHistory.getId());
		return "result-json";
	}

	public String intoUpdate() {
		scheduleHistory = scheduleHistoryService.searchById(scheduleHistory
				.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = scheduleHistoryService.update(scheduleHistory);
		return "result-jsp";
	}

	public ScheduleHistory getScheduleHistory() {
		return scheduleHistory;
	}

	public void setScheduleHistory(ScheduleHistory scheduleHistory) {
		this.scheduleHistory = scheduleHistory;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<ScheduleHistory> getScheduleHistoryList() {
		return scheduleHistoryList;
	}

	public void setScheduleHistoryList(List<ScheduleHistory> scheduleHistoryList) {
		this.scheduleHistoryList = scheduleHistoryList;
	}
}