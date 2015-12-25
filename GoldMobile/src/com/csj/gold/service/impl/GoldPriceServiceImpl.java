package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.GoldPriceMapper;
import com.csj.gold.model.GoldPrice;
import com.csj.gold.service.GoldPriceService;
import com.csj.gold.utils.page.Page;

@Service("goldPriceService")
public class GoldPriceServiceImpl implements GoldPriceService{
	
	@Resource
	GoldPriceMapper goldPriceMapper = null;

	@Override
	public int add(GoldPrice goldPrice) {
		return goldPriceMapper.insertSelective(goldPrice);
	}

	@Override
	public int update(GoldPrice goldPrice) {
		return goldPriceMapper.updateByPrimaryKeySelective(goldPrice);
	}

	@Override
	public int delete(GoldPrice goldPrice) {
		return goldPriceMapper.deleteByPrimaryKey(goldPrice.getId());
	}

	@Override
	public int forbidden(GoldPrice goldPrice) {
		return goldPriceMapper.forbiddenByPrimaryKey(goldPrice.getId());
	}

	@Override
	public List<GoldPrice> searchByParameters(Page page,GoldPrice goldPrice) {
		page.setParameters(goldPrice);
		List<GoldPrice> returnList = goldPriceMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public GoldPrice searchByPrimaryKey(GoldPrice goldPrice) {
		return goldPriceMapper.selectByPrimaryKey(goldPrice.getId());
	}

}
