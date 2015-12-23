package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysAccount;
import com.csj.gold.utils.page.Page;

public interface SysAccountMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysAccount record);

    int insertSelective(SysAccount record);

    SysAccount selectByPrimaryKey(Long id);
    
    List<SysAccount> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysAccount record);

    int updateByPrimaryKey(SysAccount record);
}