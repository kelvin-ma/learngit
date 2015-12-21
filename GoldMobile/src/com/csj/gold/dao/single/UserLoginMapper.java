package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

	List<UserLogin> selectByPhone(UserLogin user);
}