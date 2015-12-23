package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserInfo;
import com.csj.gold.utils.page.Page;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);
    
    List<UserInfo> selectByParameters(Page page);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}