package com.csj.gold.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.MobileSaveGoldMapper;
import com.csj.gold.service.MobileSaveGoldService;

@Service("mobileSaveGoldService")
public class MobileSaveGoldServiceImpl implements MobileSaveGoldService{
	
	@Resource
	private MobileSaveGoldMapper mobileSaveGoldMapper;

}
