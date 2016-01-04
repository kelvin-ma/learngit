package com.csj.gold.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.GoldPriceMapper;
import com.csj.gold.model.GoldPrice;
import com.csj.gold.model.WebGoldPrice;
import com.csj.gold.model.WebGoldPriceResult;
import com.csj.gold.service.GoldPriceService;
import com.csj.gold.utils.StaticValues;
import com.csj.gold.utils.SystemPropertiesUtils;
import com.csj.gold.utils.http.HttpRequest;
import com.csj.gold.utils.json.JsonConvert;
import com.csj.gold.utils.page.Page;

@Service("goldPriceService")
public class GoldPriceServiceImpl implements GoldPriceService {

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
	public List<GoldPrice> searchByParameters(Page page, GoldPrice goldPrice) {
		page.setParameters(goldPrice);
		List<GoldPrice> returnList = goldPriceMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public GoldPrice searchByPrimaryKey(GoldPrice goldPrice) {
		return goldPriceMapper.selectByPrimaryKey(goldPrice.getId());
	}

	@Override
	public GoldPrice searchRecentGoldPrice() {
		GoldPrice goldPrice = new GoldPrice();
		goldPrice.setIsDel(0);
		goldPrice.setIsForbidden(0);
		goldPrice.setEffectiveStartTime(new Date());
		goldPrice.setEffectiveEntTime(new Date());
		Page page = Page.newBuilderUnPage();
		page.setParameters(goldPrice);
		List<GoldPrice> list = goldPriceMapper.selectByParameters(page);
		if (null != list && list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void SearchGoldPriceFromWeb() {
		String json = HttpRequest.sendGet(SystemPropertiesUtils
				.getSystemProperties(StaticValues.WEBSIT_TO_SEARCH_GOLD_PRICE));
		WebGoldPriceResult result = (WebGoldPriceResult) JsonConvert
				.getInstance().formJson(json, WebGoldPriceResult.class);
		Map<String, WebGoldPrice> map = result.getPriceMap();
		WebGoldPrice wgp = null;
		for (String key : map.keySet()) {
			if (map.get(key).getVariety().equals("Au99.99")) {
				wgp = map.get(key);
				break;
			}
		}
		// 存储金价
	}
}
