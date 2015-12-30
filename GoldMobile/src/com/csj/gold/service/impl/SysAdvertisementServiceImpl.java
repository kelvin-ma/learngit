package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysAdvertisementMapper;
import com.csj.gold.model.SysAdvertisement;
import com.csj.gold.service.SysAdvertisementService;
import com.csj.gold.utils.page.Page;

@Service("sysAdvertisementService")
public class SysAdvertisementServiceImpl implements SysAdvertisementService{
	
	@Resource
	SysAdvertisementMapper sysAdvertisementMapper = null;

	@Override
	public int add(SysAdvertisement sysAdvertisement) {
		return sysAdvertisementMapper.insertSelective(sysAdvertisement);
	}

	@Override
	public int update(SysAdvertisement sysAdvertisement) {
		return sysAdvertisementMapper.updateByPrimaryKeySelective(sysAdvertisement);
	}

	@Override
	public int delete(SysAdvertisement sysAdvertisement) {
		return sysAdvertisementMapper.deleteByPrimaryKey(sysAdvertisement.getId());
	}

	@Override
	public int forbidden(SysAdvertisement sysAdvertisement) {
		return sysAdvertisementMapper.forbiddenByPrimaryKey(sysAdvertisement.getId());
	}

	@Override
	public List<SysAdvertisement> searchByParameters(Page page,SysAdvertisement sysAdvertisement) {
		page.setParameters(sysAdvertisement);
		List<SysAdvertisement> returnList = sysAdvertisementMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysAdvertisement searchByPrimaryKey(SysAdvertisement sysAdvertisement) {
		return sysAdvertisementMapper.selectByPrimaryKey(sysAdvertisement.getId());
	}

}
