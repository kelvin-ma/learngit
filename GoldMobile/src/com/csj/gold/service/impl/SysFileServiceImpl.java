package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysFileMapper;
import com.csj.gold.model.SysFile;
import com.csj.gold.service.SysFileService;
import com.csj.gold.utils.page.Page;

@Service("sysFileService")
public class SysFileServiceImpl implements SysFileService{
	
	@Resource
	SysFileMapper sysFileMapper = null;

	@Override
	public int add(SysFile sysFile) {
		return sysFileMapper.insertSelective(sysFile);
	}

	@Override
	public int update(SysFile sysFile) {
		return sysFileMapper.updateByPrimaryKeySelective(sysFile);
	}

	@Override
	public int delete(SysFile sysFile) {
		return sysFileMapper.deleteByPrimaryKey(sysFile.getId());
	}

	@Override
	public int forbidden(SysFile sysFile) {
		return sysFileMapper.forbiddenByPrimaryKey(sysFile.getId());
	}

	@Override
	public List<SysFile> searchByParameters(Page page,SysFile sysFile) {
		page.setParameters(sysFile);
		List<SysFile> returnList = sysFileMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysFile searchByPrimaryKey(SysFile sysFile) {
		return sysFileMapper.selectByPrimaryKey(sysFile.getId());
	}

}
