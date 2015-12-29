package com.csj.gold.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.MobileMyAccountMapper;
import com.csj.gold.service.MobileMyAccountService;

@Service("mobileMyAccountService")
public class MobileMyAccountServiceImpl implements MobileMyAccountService{
	
	@Resource
	private MobileMyAccountMapper mobileMyAccountMapper;

}
