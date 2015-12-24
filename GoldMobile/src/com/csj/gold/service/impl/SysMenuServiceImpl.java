package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysMenuMapper;
import com.csj.gold.model.SysMenu;
import com.csj.gold.service.SysMenuService;
import com.csj.gold.utils.page.Page;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService{
	
	@Resource
	SysMenuMapper sysMenuMapper = null;

	@Override
	public int add(SysMenu sysMenu) {
		return sysMenuMapper.insertSelective(sysMenu);
	}

	@Override
	public int update(SysMenu sysMenu) {
		return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
	}

	@Override
	public int delete(SysMenu sysMenu) {
		return sysMenuMapper.deleteByPrimaryKey(sysMenu.getId());
	}

	@Override
	public int forbidden(SysMenu sysMenu) {
		return sysMenuMapper.forbiddenByPrimaryKey(sysMenu.getId());
	}

	@Override
	public List<SysMenu> searchByParameters(Page page,SysMenu sysMenu) {
		page.setParameters(sysMenu);
		List<SysMenu> returnList = sysMenuMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysMenu searchByPrimaryKey(SysMenu sysMenu) {
		return sysMenuMapper.selectByPrimaryKey(sysMenu.getId());
	}

}
