package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.common.MobileStateConstants;
import com.csj.gold.mobile.vo.MobileSaveGoldParams;
import com.csj.gold.mobile.vo.MobileSaveGoldResult;
import com.csj.gold.mobile.vo.MobileShopVO;
import com.csj.gold.model.bean.MobileShop;
import com.csj.gold.service.MobileShopService;
import com.csj.gold.utils.json.JsonConvert;
@Controller
@RequestMapping(value="/saveGold",produces="text/html;charset=UTF-8")
public class MobileSaveGoldController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(MobileSaveGoldController.class);
	
	@Resource
	private MobileShopService mobileShopService;
	
	@ResponseBody
	@RequestMapping("/searchShops")  
    public String searchByUserId(MobileSaveGoldParams mobileSaveGoldParams){
		MobileSaveGoldResult mobileSaveGoldResult = new MobileSaveGoldResult();
		List<MobileShopVO> resutlBankList = new ArrayList<MobileShopVO>();
		List<MobileShopVO> resutlShopList = new ArrayList<MobileShopVO>();
		List<MobileShop> shopListTemp = mobileShopService.searchAll();
		if(null != shopListTemp && shopListTemp.size() > 0){
			MobileShopVO tempMobileShopVO = null;
			for(MobileShop temp : shopListTemp){
				tempMobileShopVO = new MobileShopVO();
				tempMobileShopVO.setId(temp.getId());
				tempMobileShopVO.setShopAddress(temp.getShopAddress());
				tempMobileShopVO.setShopCoordinateEast(temp.getShopCoordinateEast());
				tempMobileShopVO.setShopCoordinateNorth(temp.getShopCoordinateNorth());
				tempMobileShopVO.setShopImagePath(temp.getShopImagePath());
				tempMobileShopVO.setShopName(temp.getShopName());
				tempMobileShopVO.setShopPhone(temp.getShopPhone());
				if(null!=tempMobileShopVO.getShopType()){
					if(1==tempMobileShopVO.getShopType()){
						resutlBankList.add(tempMobileShopVO);
					}else if(0==tempMobileShopVO.getShopType()){
						resutlShopList.add(tempMobileShopVO);
					}
				}
			}
			mobileSaveGoldResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.SUCCESS.getIndex()));
			mobileSaveGoldResult.setResultDesc(MobileStateConstants.MobileConstants.SUCCESS.getName());
		}else{
			mobileSaveGoldResult.setResultCode(String.valueOf(MobileStateConstants.MobileConstants.NO_DATA.getIndex()));
			mobileSaveGoldResult.setResultDesc(MobileStateConstants.MobileConstants.NO_DATA.getName());
		}
		mobileSaveGoldResult.setBankDatas(resutlBankList);
		mobileSaveGoldResult.setShopDatas(resutlShopList);
		return JsonConvert.getInstance().toJson(mobileSaveGoldResult);
    } 
}
