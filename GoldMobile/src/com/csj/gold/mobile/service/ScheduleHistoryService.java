package com.csj.gold.mobile.service;
import java.util.List;

import com.csj.gold.mobile.model.ScheduleHistory;

public interface ScheduleHistoryService {

	ScheduleHistory searchById(Long id);
	
	List<ScheduleHistory> searchByParameters(ScheduleHistory scheduleHistory);
	
	int insert(ScheduleHistory scheduleHistory);

	int update(ScheduleHistory scheduleHistory);
	
	int delete(Long id);
	
	int forbidden(Long id);
}