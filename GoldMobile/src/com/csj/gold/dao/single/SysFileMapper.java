package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.SysFile;

public interface SysFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysFile record);

    int insertSelective(SysFile record);

    SysFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysFile record);

    int updateByPrimaryKey(SysFile record);

	int forbiddenByPrimaryKey(Long id);

	List<SysFile> selectByParameters(SysFile sysFile);
}