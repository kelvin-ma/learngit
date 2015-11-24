package com.csj.gold.mobile.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import com.csj.gold.mobile.model.UserInfo;

public interface UserInfoMapper {

	public  int deleteByPrimaryKey(@Param(value="id")Integer id);
	 
    public  int insert(UserInfo user);
 
    public UserInfo selectByPrimaryKey(@Param(value="id")Integer id);
 
    public int updateByPrimaryKey(UserInfo user);
 
	//public List<UserInfo> search(Page pager);
}
