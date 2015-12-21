package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysAccountTransactions;

public interface SysAccoutTransactionsMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysAccountTransactions sysAccountTransactions);

    int insertSelective(SysAccountTransactions sysAccountTransactions);

    SysAccountTransactions selectByPrimaryKey(Long id);
    
    List<SysAccountTransactions> selectByParameters(SysAccountTransactions sysAccountTransactions);

    int updateByPrimaryKeySelective(SysAccountTransactions sysAccountTransactions);

    int updateByPrimaryKey(SysAccountTransactions sysAccountTransactions);
}