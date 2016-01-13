package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.common.MobileStateConstants;
import com.csj.gold.mobile.vo.MobileAdvertisementParams;
import com.csj.gold.mobile.vo.MobileAdvertisementResult;
import com.csj.gold.mobile.vo.MobileAdvertisementVO;
import com.csj.gold.model.bean.MobileAdvertisement;
import com.csj.gold.service.MobileAdvertisementService;
import com.csj.gold.utils.json.JsonConvert;

@Controller
@RequestMapping(value="/advertisement",produces="text/html;charset=UTF-8")
public class MobileAdvertisementController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger
			.getLogger(MobileAdvertisementController.class);

	@Resource
	private MobileAdvertisementService mobileAdvertisementService;

	@ResponseBody
	@RequestMapping("/searchAll")
	public String searchByUserId(
			MobileAdvertisementParams mobileAdvertisementParams) {
		MobileAdvertisementResult mobileAdvertisementResult = new MobileAdvertisementResult();
		List<MobileAdvertisementVO> resultList = new ArrayList<MobileAdvertisementVO>();
		List<MobileAdvertisement> advertisementListTemp = mobileAdvertisementService
				.searchAll();
		if (null != advertisementListTemp && advertisementListTemp.size() > 0) {
			MobileAdvertisementVO mobileAdvertisementVO = null;
			for (MobileAdvertisement temp : advertisementListTemp) {
				mobileAdvertisementVO = new MobileAdvertisementVO();
				mobileAdvertisementVO.setId(temp.getId());
				mobileAdvertisementVO.setAdLink(temp.getAdLink());
				mobileAdvertisementVO.setFilePath(temp.getFilePath());
				mobileAdvertisementVO.setId(temp.getId());
				mobileAdvertisementVO.setLinkParameters(temp
						.getLinkParameters());
				mobileAdvertisementVO.setOrderNumber(temp.getOrderNumber());
				mobileAdvertisementVO.setVersion(temp.getVersion());
				resultList.add(mobileAdvertisementVO);
			}
			MobileControllerUtils.setResultCodeAndDesc(mobileAdvertisementResult, MobileStateConstants.MobileConstants.SUCCESS);
			mobileAdvertisementResult.setDatas(resultList);
		} else {
			MobileControllerUtils.setResultCodeAndDesc(mobileAdvertisementResult, MobileStateConstants.MobileConstants.NO_DATA);
		}
		return JsonConvert.getInstance().toJson(mobileAdvertisementResult);
	}

}
