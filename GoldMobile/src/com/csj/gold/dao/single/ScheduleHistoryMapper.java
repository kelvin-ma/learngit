package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.ScheduleHistory;
import com.csj.gold.utils.page.Page;

public interface ScheduleHistoryMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(ScheduleHistory record);

    int insertSelective(ScheduleHistory record);

    ScheduleHistory selectByPrimaryKey(Long id);
    
    List<ScheduleHistory> selectByParameters(Page page);

    int updateByPrimaryKeySelective(ScheduleHistory record);

    int updateByPrimaryKey(ScheduleHistory record);
}