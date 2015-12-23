package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysContact;
import com.csj.gold.utils.page.Page;

public interface SysContactMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysContact record);

    int insertSelective(SysContact record);

    SysContact selectByPrimaryKey(Long id);
    
    List<SysContact> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysContact record);

    int updateByPrimaryKey(SysContact record);
}