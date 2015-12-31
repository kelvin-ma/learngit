package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.MobileShopMapper;
import com.csj.gold.model.bean.MobileShop;
import com.csj.gold.service.MobileShopService;

@Service("mobileShopService")
public class MobileShopServiceImpl implements MobileShopService{
	
	@Resource
	private MobileShopMapper mobileShopMapper;

	@Override
	public List<MobileShop> searchAll() {
		return mobileShopMapper.searchAll();
	}
	
	@Override
	public List<MobileShop> searchAllSaveShop() {
		return mobileShopMapper.searchAllSaveShop();
	}
	
	@Override
	public List<MobileShop> searchAllPickShop() {
		return mobileShopMapper.searchAllPickShop();
	}

}
