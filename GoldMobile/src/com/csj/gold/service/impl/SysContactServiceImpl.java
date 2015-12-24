package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.SysContactMapper;
import com.csj.gold.model.SysContact;
import com.csj.gold.service.SysContactService;
import com.csj.gold.utils.page.Page;

@Service("sysContactService")
public class SysContactServiceImpl implements SysContactService{
	
	@Resource
	SysContactMapper sysContactMapper = null;

	@Override
	public int add(SysContact sysContact) {
		return sysContactMapper.insertSelective(sysContact);
	}

	@Override
	public int update(SysContact sysContact) {
		return sysContactMapper.updateByPrimaryKeySelective(sysContact);
	}

	@Override
	public int delete(SysContact sysContact) {
		return sysContactMapper.deleteByPrimaryKey(sysContact.getId());
	}

	@Override
	public int forbidden(SysContact sysContact) {
		return sysContactMapper.forbiddenByPrimaryKey(sysContact.getId());
	}

	@Override
	public List<SysContact> searchByParameters(Page page,SysContact sysContact) {
		page.setParameters(sysContact);
		List<SysContact> returnList = sysContactMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public SysContact searchByPrimaryKey(SysContact sysContact) {
		return sysContactMapper.selectByPrimaryKey(sysContact.getId());
	}

}
