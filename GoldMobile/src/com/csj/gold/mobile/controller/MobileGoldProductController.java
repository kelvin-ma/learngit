package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.vo.MobileGoldProductParams;
import com.csj.gold.mobile.vo.MobileGoldProductResult;
import com.csj.gold.mobile.vo.MobileGoldProductVO;
import com.csj.gold.mobile.vo.MobileUserAddressParams;
import com.csj.gold.mobile.vo.MobileUserAddressResult;
import com.csj.gold.mobile.vo.MobileUserAddressVO;
import com.csj.gold.model.UserAddress;
import com.csj.gold.model.bean.MobileGoldProduct;
import com.csj.gold.service.MobileGoldProductService;
import com.csj.gold.service.MobileUserAddressService;
import com.csj.gold.utils.json.JsonConvert;
@Controller
@RequestMapping("/product")
public class MobileGoldProductController {
	
	@Resource
	private MobileGoldProductService mobileGoldProductService;
	
	@RequestMapping("/searchAll")  
    public String searchAll(MobileGoldProductParams mobileGoldProductParams){
		MobileGoldProductResult mobileGoldProductResult = new MobileGoldProductResult();
		List<MobileGoldProductVO> resutlProductList = new ArrayList<MobileGoldProductVO>();
		List<MobileGoldProduct> productListTemp = mobileGoldProductService.searchAll();
		MobileGoldProduct mobileGoldProduct  = null;
		if(null != productListTemp && productListTemp.size()>0){
			for(MobileGoldProduct temp : productListTemp){
				mobileGoldProduct = new MobileGoldProduct();
				mobileGoldProduct.setImageFilePath(temp.getImageFilePath());
				mobileGoldProduct.setpExpiryDay(temp.getpExpiryDay());
				mobileGoldProduct.setpExpiryMonth(temp.getpExpiryMonth());
				mobileGoldProduct.setpExpiryYear(temp.getpExpiryYear());
				mobileGoldProduct.setpInterestModel(temp.getpInterestModel());
				mobileGoldProduct.setpInterestRateDay(temp.getpInterestRateDay());
				mobileGoldProduct.setpInterestRateMonth(temp.getpInterestRateMonth());
				mobileGoldProduct.setpInterestRateYear(temp.getpInterestRateYear());
				mobileGoldProduct.setProductId(temp.getProductId());
				mobileGoldProduct.setProductName(temp.getProductName());
				mobileGoldProduct.setTraAddNum(temp.getTraAddNum());
				mobileGoldProduct.setTraMaxNum(temp.getTraMaxNum());
				mobileGoldProduct.setTraMinNum(temp.getTraMinNum());
			}
		}
		mobileGoldProductResult.setData(resutlProductList);
		return JsonConvert.getInstance().toJson(mobileGoldProductResult);
    }  
}
