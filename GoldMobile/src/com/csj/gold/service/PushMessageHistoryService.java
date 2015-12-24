package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.PushMessageHistory;
import com.csj.gold.utils.page.Page;

public interface PushMessageHistoryService {
	int add(PushMessageHistory pushMessageHistory);

	int update(PushMessageHistory pushMessageHistory);

	int delete(PushMessageHistory pushMessageHistory);

	int forbidden(PushMessageHistory pushMessageHistory);

	List<PushMessageHistory> searchByParameters(Page page,PushMessageHistory pushMessageHistory);

	PushMessageHistory searchByPrimaryKey(PushMessageHistory pushMessageHistory);
}