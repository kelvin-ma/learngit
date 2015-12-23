package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserRole;
import com.csj.gold.utils.page.Page;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);
    
    List<UserRole> selectByParameters(Page page);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}