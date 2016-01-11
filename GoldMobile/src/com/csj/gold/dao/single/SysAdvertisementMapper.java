package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysAdvertisement;
import com.csj.gold.utils.page.Page;

public interface SysAdvertisementMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(SysAdvertisement record);

    int insertSelective(SysAdvertisement record);

    SysAdvertisement selectByPrimaryKey(Long id);
    
    List<SysAdvertisement> selectByParameters(Page page);

    int updateByPrimaryKeySelective(SysAdvertisement record);

    int updateByPrimaryKey(SysAdvertisement record);
}