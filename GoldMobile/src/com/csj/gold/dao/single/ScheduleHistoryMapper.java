package com.csj.gold.dao.single;

import com.csj.gold.model.ScheduleHistory;

public interface ScheduleHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ScheduleHistory record);

    int insertSelective(ScheduleHistory record);

    ScheduleHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ScheduleHistory record);

    int updateByPrimaryKey(ScheduleHistory record);
}