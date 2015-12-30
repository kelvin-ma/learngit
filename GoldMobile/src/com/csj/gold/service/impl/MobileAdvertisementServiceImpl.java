package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.MobileAdvertisementMapper;
import com.csj.gold.model.bean.MobileAdvertisement;
import com.csj.gold.service.MobileAdvertisementService;

@Service("mobileAdvertisementService")
public class MobileAdvertisementServiceImpl implements MobileAdvertisementService{
	
	@Resource
	private MobileAdvertisementMapper mobileAdvertisementMapper;

	@Override
	public List<MobileAdvertisement> searchAll() {
		return mobileAdvertisementMapper.searchAll();
	}

}
