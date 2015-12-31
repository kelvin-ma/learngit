package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.vo.MobileSaveGoldParams;
import com.csj.gold.mobile.vo.MobileSaveGoldResult;
import com.csj.gold.mobile.vo.MobileShopVO;
import com.csj.gold.model.SysShop;
import com.csj.gold.service.SysShopService;
import com.csj.gold.utils.json.JsonConvert;
import com.csj.gold.utils.page.Page;
@Controller
@RequestMapping("/saveGold")
public class MobileSaveGoldController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(MobileSaveGoldController.class);
	
	@Resource
	private SysShopService sysShopService;
	
	@ResponseBody
	@RequestMapping("/searchShops")  
    public String searchByUserId(MobileSaveGoldParams mobileSaveGoldParams){
		MobileSaveGoldResult mobileSaveGoldResult = new MobileSaveGoldResult();
		List<MobileShopVO> resutlBankList = new ArrayList<MobileShopVO>();
		List<MobileShopVO> resutlShopList = new ArrayList<MobileShopVO>();
		SysShop sysShop = new SysShop();
		sysShop.setIsDel(0);
		sysShop.setIsForbidden(0);
		sysShop.setCanSave(1);
		Page page = Page.newBuilderUnPage();
		List<SysShop> shopListTemp = sysShopService.searchByParameters(page,sysShop);
		if(null != shopListTemp && shopListTemp.size() > 0){
			MobileShopVO tempMobileShopVO = null;
			for(SysShop temp : shopListTemp){
				tempMobileShopVO = new MobileShopVO();
				tempMobileShopVO.setId(temp.getId());
				tempMobileShopVO.setShopAddress(temp.getShopAddress());
				tempMobileShopVO.setShopCoordinateEast(temp.getShopCoordinateEast());
				tempMobileShopVO.setShopCoordinateNorth(temp.getShopCoordinateNorth());
			}
		}
		mobileSaveGoldResult.setBankDatas(resutlBankList);
		mobileSaveGoldResult.setShopDatas(resutlShopList);
		return JsonConvert.getInstance().toJson(mobileSaveGoldResult);
    } 
	
}
