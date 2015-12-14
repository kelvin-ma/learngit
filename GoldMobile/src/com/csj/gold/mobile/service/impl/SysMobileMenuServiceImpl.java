package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysMobileMenuMapper;
import com.csj.gold.mobile.model.SysMobileMenu;
import com.csj.gold.mobile.service.SysMobileMenuService;

@Service("sysMobileMenuService")
public class SysMobileMenuServiceImpl implements SysMobileMenuService {

	@Resource
	private SysMobileMenuMapper sysMobileMenuMapper;
	
	public SysMobileMenu searchById(Long id){
		return sysMobileMenuMapper.selectByPrimaryKey(id);
	}
	
	public List<SysMobileMenu> searchByParameters(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.selectByParameters(sysMobileMenu);
	}
	
	@Transactional
	public int insert(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.insert(sysMobileMenu);
	}
	
	@Transactional
	public int update(SysMobileMenu sysMobileMenu) {
		return sysMobileMenuMapper.updateByPrimaryKey(sysMobileMenu);
	}
	
	@Transactional
	public int delete(Long id){
		return sysMobileMenuMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return sysMobileMenuMapper.updateForbiddenByPrimaryKey(id);
	}
	
}