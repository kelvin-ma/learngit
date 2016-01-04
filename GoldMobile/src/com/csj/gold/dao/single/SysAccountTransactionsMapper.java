package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysAccountTransactions;
import com.csj.gold.utils.page.Page;

public interface SysAccountTransactionsMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysAccountTransactions sysAccountTransactions);

    int insertSelective(SysAccountTransactions sysAccountTransactions);

    SysAccountTransactions selectByPrimaryKey(Long id);
    
    List<SysAccountTransactions> selectByParameters(Page page);
    
    int updateByPrimaryKeySelective(SysAccountTransactions sysAccountTransactions);

    int updateByPrimaryKey(SysAccountTransactions sysAccountTransactions);
}