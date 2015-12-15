package com.csj.gold.dao.single;

import com.csj.gold.model.UserProduct;

public interface UserProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserProduct record);

    int insertSelective(UserProduct record);

    UserProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserProduct record);

    int updateByPrimaryKey(UserProduct record);
}