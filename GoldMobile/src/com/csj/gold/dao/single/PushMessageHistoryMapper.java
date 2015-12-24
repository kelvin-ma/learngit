package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.PushMessageHistory;
import com.csj.gold.utils.page.Page;

public interface PushMessageHistoryMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(PushMessageHistory record);

    int insertSelective(PushMessageHistory record);

    PushMessageHistory selectByPrimaryKey(Long id);
    
    List<PushMessageHistory> selectByParameters(Page page);

    int updateByPrimaryKeySelective(PushMessageHistory record);

    int updateByPrimaryKey(PushMessageHistory record);
}