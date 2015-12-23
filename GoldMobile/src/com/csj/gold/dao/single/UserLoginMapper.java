package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserLogin;
import com.csj.gold.model.UserProduct;
import com.csj.gold.utils.page.Page;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Long id);
    
    List<UserLogin> selectByParameters(Page page);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

	List<UserLogin> selectByPhone(UserLogin user);
}