package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserBankcard;
import com.csj.gold.utils.page.Page;

public interface UserBankcardMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(UserBankcard record);

    int insertSelective(UserBankcard record);

    UserBankcard selectByPrimaryKey(Long id);
    
    List<UserBankcard> selectByParameters(Page page);

    int updateByPrimaryKeySelective(UserBankcard record);

    int updateByPrimaryKey(UserBankcard record);
}