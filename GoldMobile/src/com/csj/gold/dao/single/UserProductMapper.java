package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserProduct;
import com.csj.gold.model.UserRole;
import com.csj.gold.utils.page.Page;

public interface UserProductMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(UserProduct record);

    int insertSelective(UserProduct record);

    UserProduct selectByPrimaryKey(Long id);
    
    List<UserProduct> selectByParameters(Page page);

    int updateByPrimaryKeySelective(UserProduct record);

    int updateByPrimaryKey(UserProduct record);
}