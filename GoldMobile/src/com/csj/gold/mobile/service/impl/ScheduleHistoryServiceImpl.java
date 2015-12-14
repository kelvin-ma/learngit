package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.ScheduleHistoryMapper;
import com.csj.gold.mobile.model.ScheduleHistory;
import com.csj.gold.mobile.service.ScheduleHistoryService;

@Service("scheduleHistoryService")
public class ScheduleHistoryServiceImpl implements ScheduleHistoryService {

	@Resource
	private ScheduleHistoryMapper scheduleHistoryMapper;
	
	public ScheduleHistory searchById(Long id){
		return scheduleHistoryMapper.selectByPrimaryKey(id);
	}
	
	public List<ScheduleHistory> searchByParameters(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.selectByParameters(scheduleHistory);
	}
	
	@Transactional
	public int insert(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.insert(scheduleHistory);
	}
	
	@Transactional
	public int update(ScheduleHistory scheduleHistory) {
		return scheduleHistoryMapper.updateByPrimaryKey(scheduleHistory);
	}
	
	@Transactional
	public int delete(Long id){
		return scheduleHistoryMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return scheduleHistoryMapper.updateForbiddenByPrimaryKey(id);
	}
	
}