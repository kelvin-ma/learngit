package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	List<UserInfo> selectByParameters(UserInfo userInfo);
}