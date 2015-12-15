package com.csj.gold.dao.single;

import com.csj.gold.model.SysAccoutTransactions;

public interface SysAccoutTransactionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAccoutTransactions record);

    int insertSelective(SysAccoutTransactions record);

    SysAccoutTransactions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAccoutTransactions record);

    int updateByPrimaryKey(SysAccoutTransactions record);
}