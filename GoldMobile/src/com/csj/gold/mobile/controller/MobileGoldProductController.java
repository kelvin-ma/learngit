package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csj.gold.mobile.common.MobileStateConstants;
import com.csj.gold.mobile.vo.MobileGoldProductParams;
import com.csj.gold.mobile.vo.MobileGoldProductResult;
import com.csj.gold.mobile.vo.MobileGoldProductVO;
import com.csj.gold.model.bean.MobileGoldProduct;
import com.csj.gold.service.MobileGoldProductService;
import com.csj.gold.utils.StringUtils;
import com.csj.gold.utils.json.JsonConvert;
import com.csj.gold.utils.page.Page;
@Controller
@RequestMapping(value="/product",produces="text/html;charset=UTF-8")
public class MobileGoldProductController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(MobileGoldProductController.class);
	
	@Resource
	private MobileGoldProductService mobileGoldProductService;
	
	@ResponseBody
	@RequestMapping("/searchAll")  
    public String searchAll(MobileGoldProductParams mobileGoldProductParams){
		MobileGoldProductResult mobileGoldProductResult = new MobileGoldProductResult();
		List<MobileGoldProductVO> resutlProductList = new ArrayList<MobileGoldProductVO>();
		List<MobileGoldProduct> productListTemp = mobileGoldProductService.searchAll();
		MobileGoldProductVO mobileGoldProductVO  = null;
		if(null != productListTemp && productListTemp.size()>0){
			for(MobileGoldProduct temp : productListTemp){
				mobileGoldProductVO = new MobileGoldProductVO();
				mobileGoldProductVO.setImageFilePath(temp.getImageFilePath());
				mobileGoldProductVO.setpExpiryDay(temp.getpExpiryDay());
				mobileGoldProductVO.setpExpiryMonth(temp.getpExpiryMonth());
				mobileGoldProductVO.setpExpiryYear(temp.getpExpiryYear());
				mobileGoldProductVO.setpInterestModel(temp.getpInterestModel());
				mobileGoldProductVO.setpInterestRateDay(temp.getpInterestRateDay());
				mobileGoldProductVO.setpInterestRateMonth(temp.getpInterestRateMonth());
				mobileGoldProductVO.setpInterestRateYear(temp.getpInterestRateYear());
				mobileGoldProductVO.setProductId(temp.getProductId());
				mobileGoldProductVO.setProductName(temp.getProductName());
				mobileGoldProductVO.setTraAddNum(temp.getTraAddNum());
				mobileGoldProductVO.setTraMaxNum(temp.getTraMaxNum());
				mobileGoldProductVO.setTraMinNum(temp.getTraMinNum());
				resutlProductList.add(mobileGoldProductVO);
			}
			MobileControllerUtils.setResultCodeAndDesc(mobileGoldProductResult, MobileStateConstants.MobileConstants.SUCCESS);
		}else{
			MobileControllerUtils.setResultCodeAndDesc(mobileGoldProductResult, MobileStateConstants.MobileConstants.NO_DATA);
		}
		mobileGoldProductResult.setData(resutlProductList);
		return JsonConvert.getInstance().toJson(mobileGoldProductResult);
    }
	@ResponseBody
	@RequestMapping("/searchDetail")  
    public String searchDetail(MobileGoldProductParams mobileGoldProductParams){
		MobileGoldProductResult mobileGoldProductResult = new MobileGoldProductResult();
		if(!StringUtils.checkStringNullAndEmpty(mobileGoldProductParams.getPhone())||!StringUtils.checkStringNullAndEmpty(mobileGoldProductParams.getPhoneCode())){
			MobileControllerUtils.setResultCodeAndDesc(mobileGoldProductResult, MobileStateConstants.MobileConstants.SHORT_PARAMETER);
			return JsonConvert.getInstance().toJson(mobileGoldProductResult);
		}
		if(null == mobileGoldProductParams.getProductId()){
			MobileControllerUtils.setResultCodeAndDesc(mobileGoldProductResult, MobileStateConstants.MobileConstants.WRONG_PARAMETER);
			return JsonConvert.getInstance().toJson(mobileGoldProductResult);
		}
		List<MobileGoldProductVO> resutlProductList = new ArrayList<MobileGoldProductVO>();
		MobileGoldProduct mobileGoldProduct = new MobileGoldProduct();
		mobileGoldProduct.setProductId(mobileGoldProductParams.getProductId());
		Page page = Page.newBuilderUnPage();
		List<MobileGoldProduct> productListTemp = mobileGoldProductService.searchByParameters(page, mobileGoldProduct);
		MobileGoldProductVO mobileGoldProductVO = null;
		if(null != productListTemp && productListTemp.size()==1){
			for(MobileGoldProduct temp : productListTemp){
				mobileGoldProductVO = new MobileGoldProductVO();
				mobileGoldProductVO.setImageFilePath(temp.getImageFilePath());
				mobileGoldProductVO.setpExpiryDay(temp.getpExpiryDay());
				mobileGoldProductVO.setpExpiryMonth(temp.getpExpiryMonth());
				mobileGoldProductVO.setpExpiryYear(temp.getpExpiryYear());
				mobileGoldProductVO.setpInterestModel(temp.getpInterestModel());
				mobileGoldProductVO.setpInterestRateDay(temp.getpInterestRateDay());
				mobileGoldProductVO.setpInterestRateMonth(temp.getpInterestRateMonth());
				mobileGoldProductVO.setpInterestRateYear(temp.getpInterestRateYear());
				mobileGoldProductVO.setProductId(temp.getProductId());
				mobileGoldProductVO.setProductName(temp.getProductName());
				mobileGoldProductVO.setTraAddNum(temp.getTraAddNum());
				mobileGoldProductVO.setTraMaxNum(temp.getTraMaxNum());
				mobileGoldProductVO.setTraMinNum(temp.getTraMinNum());
				resutlProductList.add(mobileGoldProductVO);
			}
			MobileControllerUtils.setResultCodeAndDesc(mobileGoldProductResult, MobileStateConstants.MobileConstants.SUCCESS);
		}else{
			MobileControllerUtils.setResultCodeAndDesc(mobileGoldProductResult, MobileStateConstants.MobileConstants.NO_DATA);
		}
		mobileGoldProductResult.setData(resutlProductList);
		return JsonConvert.getInstance().toJson(mobileGoldProductResult);
    }
}
