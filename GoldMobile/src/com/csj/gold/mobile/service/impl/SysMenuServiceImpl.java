package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysMenuMapper;
import com.csj.gold.mobile.model.SysMenu;
import com.csj.gold.mobile.service.SysMenuService;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	private SysMenuMapper sysMenuMapper;
	
	public SysMenu searchById(Long id){
		return sysMenuMapper.selectByPrimaryKey(id);
	}
	
	public List<SysMenu> searchByParameters(SysMenu sysMenu) {
		return sysMenuMapper.selectByParameters(sysMenu);
	}
	
	@Transactional
	public int insert(SysMenu sysMenu) {
		return sysMenuMapper.insert(sysMenu);
	}
	
	@Transactional
	public int update(SysMenu sysMenu) {
		return sysMenuMapper.updateByPrimaryKey(sysMenu);
	}
	
	@Transactional
	public int delete(Long id){
		return sysMenuMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return sysMenuMapper.updateForbiddenByPrimaryKey(id);
	}
	
}