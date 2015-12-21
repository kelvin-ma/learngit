package com.csj.gold;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.csj.gold.mobile.vo.MobileGoldProductResult;
import com.csj.gold.mobile.vo.MobileGoldProductVO;
import com.csj.gold.model.bean.MobileGoldProduct;
import com.csj.gold.service.MobileGoldProductService;
import com.csj.gold.service.MobileUserAddressService;
import com.csj.gold.utils.json.JsonConvert;


public class MyBatisGoldProductTest {
	private MobileGoldProductService mobileGoldProductService;
	
	@Before
	 public void init() {
	  
	  ApplicationContext aCtx = new FileSystemXmlApplicationContext(
	    "classpath:applicationContext.xml");
	  MobileGoldProductService mobileGoldProductService = (MobileGoldProductService) aCtx
	    .getBean("mobileGoldProductService");
	  this.mobileGoldProductService = mobileGoldProductService;

	 }

	@Test
	public void testGoldProduct(){
		MobileGoldProductResult mobileGoldProductResult = new MobileGoldProductResult();
		List<MobileGoldProductVO> resutlProductList = new ArrayList<MobileGoldProductVO>();
		List<MobileGoldProduct> productListTemp = mobileGoldProductService.searchAll();
		System.out.println(productListTemp.size());
		MobileGoldProductVO mobileGoldProduct  = null;
		if(null != productListTemp && productListTemp.size()>0){
			for(MobileGoldProduct temp : productListTemp){
				mobileGoldProduct = new MobileGoldProductVO();
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
				resutlProductList.add(mobileGoldProduct);
			}
		}
		mobileGoldProductResult.setData(resutlProductList);
		System.out.println(JsonConvert.getInstance().toJson(mobileGoldProductResult));
	}

}
