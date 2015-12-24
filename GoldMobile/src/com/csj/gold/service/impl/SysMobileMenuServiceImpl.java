package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysMobileMenuMapper;
import com.csj.gold.model.SysMobileMenu;
import com.csj.gold.service.SysMobileMenuService;
import com.csj.gold.utils.page.Page;

@Service("sysMobileMenuService")
public class SysMobileMenuServiceImpl implements SysMobileMenuService{
	
	@Resource
	SysMobileMenuMapper sysMobileMenuMapper = null;

	@Override
	public int add(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.insertSelective(sysMobileMenu);
	}

	@Override
	public int update(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.updateByPrimaryKeySelective(sysMobileMenu);
	}

	@Override
	public int delete(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.deleteByPrimaryKey(sysMobileMenu.getId());
	}

	@Override
	public int forbidden(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.forbiddenByPrimaryKey(sysMobileMenu.getId());
	}

	@Override
	public List<SysMobileMenu> searchByParameters(Page page,SysMobileMenu sysMobileMenu) {
		page.setParameters(sysMobileMenu);
		List<SysMobileMenu> returnList = sysMobileMenuMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysMobileMenu searchByPrimaryKey(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.selectByPrimaryKey(sysMobileMenu.getId());
	}

}
