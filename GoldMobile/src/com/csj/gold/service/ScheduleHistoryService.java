package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.ScheduleHistory;
import com.csj.gold.utils.page.Page;

public interface ScheduleHistoryService {
	int add(ScheduleHistory scheduleHistory);

	int update(ScheduleHistory scheduleHistory);

	int delete(ScheduleHistory scheduleHistory);

	int forbidden(ScheduleHistory scheduleHistory);

	List<ScheduleHistory> searchByParameters(Page page,ScheduleHistory scheduleHistory);

	ScheduleHistory searchByPrimaryKey(ScheduleHistory scheduleHistory);
}
