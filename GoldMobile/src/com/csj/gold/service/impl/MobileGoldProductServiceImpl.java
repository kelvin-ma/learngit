package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.MobileGoldProductMapper;
import com.csj.gold.mobile.vo.MobileGoldProductVO;
import com.csj.gold.model.bean.MobileGoldProduct;
import com.csj.gold.service.MobileGoldProductService;

@Service("mobileGoldProductService")
public class MobileGoldProductServiceImpl implements MobileGoldProductService{
	
	@Resource
	private MobileGoldProductMapper mobileGoldProductMapper;

	@Override
	public List<MobileGoldProduct> searchAll() {
		return mobileGoldProductMapper.searchAll();
	}

	@Override
	public List<MobileGoldProduct> searchByParameters(MobileGoldProduct mobileGoldProduct) {
		return mobileGoldProductMapper.searchByParameters(mobileGoldProduct);
	}

}
