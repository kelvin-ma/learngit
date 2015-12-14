package com.csj.gold.mobile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csj.gold.mobile.dao.SysFileMapper;
import com.csj.gold.mobile.model.SysFile;
import com.csj.gold.mobile.service.SysFileService;

@Service("sysFileService")
public class SysFileServiceImpl implements SysFileService {

	@Resource
	private SysFileMapper sysFileMapper;
	
	public SysFile searchById(Long id){
		return sysFileMapper.selectByPrimaryKey(id);
	}
	
	public List<SysFile> searchByParameters(SysFile sysFile) {
		return sysFileMapper.selectByParameters(sysFile);
	}
	
	@Transactional
	public int insert(SysFile sysFile) {
		return sysFileMapper.insert(sysFile);
	}
	
	@Transactional
	public int update(SysFile sysFile) {
		return sysFileMapper.updateByPrimaryKey(sysFile);
	}
	
	@Transactional
	public int delete(Long id){
		return sysFileMapper.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int forbidden(Long id){
		return sysFileMapper.updateForbiddenByPrimaryKey(id);
	}
	
}