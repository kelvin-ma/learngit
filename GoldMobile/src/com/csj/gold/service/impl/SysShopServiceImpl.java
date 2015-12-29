package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysShopMapper;
import com.csj.gold.model.SysShop;
import com.csj.gold.service.SysShopService;
import com.csj.gold.utils.page.Page;

@Service("sysShopService")
public class SysShopServiceImpl implements SysShopService{
	
	@Resource
	SysShopMapper sysShopMapper = null;

	@Override
	public int add(SysShop sysShop) {
		return sysShopMapper.insertSelective(sysShop);
	}

	@Override
	public int update(SysShop sysShop) {
		return sysShopMapper.updateByPrimaryKeySelective(sysShop);
	}

	@Override
	public int delete(SysShop sysShop) {
		return sysShopMapper.deleteByPrimaryKey(sysShop.getId());
	}

	@Override
	public int forbidden(SysShop sysShop) {
		return sysShopMapper.forbiddenByPrimaryKey(sysShop.getId());
	}

	@Override
	public List<SysShop> searchByParameters(Page page,SysShop sysShop) {
		page.setParameters(sysShop);
		List<SysShop> returnList = sysShopMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysShop searchByPrimaryKey(SysShop sysShop) {
		return sysShopMapper.selectByPrimaryKey(sysShop.getId());
	}

}
