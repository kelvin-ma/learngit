package com.csj.gold.dao.single;

import com.csj.gold.model.UserBankcard;

public interface UserBankcardMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(UserBankcard record);

    int insertSelective(UserBankcard record);

    UserBankcard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBankcard record);

    int updateByPrimaryKey(UserBankcard record);
}