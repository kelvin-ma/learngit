package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.ScheduleHistoryMapper;
import com.csj.gold.model.ScheduleHistory;
import com.csj.gold.service.ScheduleHistoryService;
import com.csj.gold.utils.page.Page;

@Service("scheduleHistoryService")
public class ScheduleHistoryServiceImpl implements ScheduleHistoryService{
	
	@Resource
	ScheduleHistoryMapper scheduleHistoryMapper = null;

	@Override
	public int add(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.insertSelective(scheduleHistory);
	}

	@Override
	public int update(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.updateByPrimaryKeySelective(scheduleHistory);
	}

	@Override
	public int delete(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.deleteByPrimaryKey(scheduleHistory.getId());
	}

	@Override
	public int forbidden(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.forbiddenByPrimaryKey(scheduleHistory.getId());
	}

	@Override
	public List<ScheduleHistory> searchByParameters(Page page,ScheduleHistory scheduleHistory) {
		page.setParameters(scheduleHistory);
		List<ScheduleHistory> returnList = scheduleHistoryMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public ScheduleHistory searchByPrimaryKey(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.selectByPrimaryKey(scheduleHistory.getId());
	}

}
