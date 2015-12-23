package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.RoleAuthority;
import com.csj.gold.utils.page.Page;

public interface RoleAuthorityMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);
    
    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    RoleAuthority selectByPrimaryKey(Long id);
    
    List<RoleAuthority> selectByParameters(Page page);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);
}