package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.PushMessageHistoryMapper;
import com.csj.gold.model.PushMessageHistory;
import com.csj.gold.service.PushMessageHistoryService;
import com.csj.gold.utils.page.Page;

@Service("pushMessageHistoryService")
public class PushMessageHistoryServiceImpl implements PushMessageHistoryService{
	
	@Resource
	PushMessageHistoryMapper pushMessageHistoryMapper = null;

	@Override
	public int add(PushMessageHistory pushMessageHistory) {
		return pushMessageHistoryMapper.insertSelective(pushMessageHistory);
	}

	@Override
	public int update(PushMessageHistory pushMessageHistory) {
		return pushMessageHistoryMapper.updateByPrimaryKeySelective(pushMessageHistory);
	}

	@Override
	public int delete(PushMessageHistory pushMessageHistory) {
		return pushMessageHistoryMapper.deleteByPrimaryKey(pushMessageHistory.getId());
	}

	@Override
	public int forbidden(PushMessageHistory pushMessageHistory) {
		return pushMessageHistoryMapper.forbiddenByPrimaryKey(pushMessageHistory.getId());
	}

	@Override
	public List<PushMessageHistory> searchByParameters(Page page,PushMessageHistory pushMessageHistory) {
		page.setParameters(pushMessageHistory);
		List<PushMessageHistory> returnList = pushMessageHistoryMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public PushMessageHistory searchByPrimaryKey(PushMessageHistory pushMessageHistory) {
		return pushMessageHistoryMapper.selectByPrimaryKey(pushMessageHistory.getId());
	}

}
