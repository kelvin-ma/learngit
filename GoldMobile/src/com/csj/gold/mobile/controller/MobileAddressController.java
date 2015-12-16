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
@RequestMapping("/address")
public class MobileAddressController {
	@Resource
	private MobileUserAddressService mobileUserAddressService;
	
	@RequestMapping("/searchByUserId")  
    public String searchByUserId(MobileUserAddressParams mobileUserAddressParams){
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(mobileUserAddressParams.getUserId());
		List<UserAddress> addressListTemp = mobileUserAddressService.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if(null == resutlAddressList){
			resutlAddressList = new ArrayList<MobileUserAddressVO>();
		}
		mobileUserAddressResult.setData(resutlAddressList);
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
    } 
	
	@RequestMapping("/changeMainAddress")
	public String changeMainAddress(MobileUserAddressParams mobileUserAddressParams){
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(mobileUserAddressParams.getUserId());
		userAddress.setId(mobileUserAddressParams.getAddressId());
		mobileUserAddressService.changeMainAddress(userAddress);
		List<UserAddress> addressListTemp = mobileUserAddressService.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if(null == resutlAddressList){
			resutlAddressList = new ArrayList<MobileUserAddressVO>();
		}
		mobileUserAddressResult.setData(resutlAddressList);
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}
	
	@RequestMapping("/addAddress")
	public String addAddress(MobileUserAddressParams mobileUserAddressParams){
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(mobileUserAddressParams.getUserId());
		userAddress.setAddress(mobileUserAddressParams.getAddress());
		userAddress.setConsignee(mobileUserAddressParams.getConsignee());
		userAddress.setPhone(mobileUserAddressParams.getPhone());
		userAddress.setIsDel(0);
		userAddress.setIsForbidden(0);
		userAddress.setIsMain(0);
		mobileUserAddressService.addAddress(userAddress);
		List<UserAddress> addressListTemp = mobileUserAddressService.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if(null == resutlAddressList){
			resutlAddressList = new ArrayList<MobileUserAddressVO>();
		}
		mobileUserAddressResult.setData(resutlAddressList);
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}
	
	@RequestMapping("/deleteAddress")
	public String updateAddress(MobileUserAddressParams mobileUserAddressParams){
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(mobileUserAddressParams.getUserId());
		userAddress.setId(mobileUserAddressParams.getAddressId());
		userAddress.setAddress(mobileUserAddressParams.getAddress());
		userAddress.setConsignee(mobileUserAddressParams.getConsignee());
		userAddress.setPhone(mobileUserAddressParams.getPhone());
		mobileUserAddressService.updateAddress(userAddress);
		List<UserAddress> addressListTemp = mobileUserAddressService.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if(null == resutlAddressList){
			resutlAddressList = new ArrayList<MobileUserAddressVO>();
		}
		mobileUserAddressResult.setData(resutlAddressList);
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}
	
	@RequestMapping("/updateAddress")
	public String deleteAddress(MobileUserAddressParams mobileUserAddressParams){
		MobileUserAddressResult mobileUserAddressResult = new MobileUserAddressResult();
		List<MobileUserAddressVO> resutlAddressList = null;
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(mobileUserAddressParams.getUserId());
		userAddress.setId(mobileUserAddressParams.getAddressId());
		userAddress.setIsDel(1);
		userAddress.setIsMain(0);
		mobileUserAddressService.addAddress(userAddress);
		List<UserAddress> addressListTemp = mobileUserAddressService.searchByUserId(userAddress);
		resutlAddressList = traceToMobileUserAddressVOList(addressListTemp);
		if(null == resutlAddressList){
			resutlAddressList = new ArrayList<MobileUserAddressVO>();
		}
		mobileUserAddressResult.setData(resutlAddressList);
		return JsonConvert.getInstance().toJson(mobileUserAddressResult);
	}
	
	private List<MobileUserAddressVO> traceToMobileUserAddressVOList(List<UserAddress> addressListTemp){
		List<MobileUserAddressVO> resutlAddressList = new ArrayList<MobileUserAddressVO>();
		MobileUserAddressVO mobileUserAddressVO  = null;
		if(null != addressListTemp && addressListTemp.size()>0){
			for(UserAddress temp : addressListTemp){
				mobileUserAddressVO = new MobileUserAddressVO();
				mobileUserAddressVO.setAddress(temp.getAddress());
				mobileUserAddressVO.setConsignee(temp.getConsignee());
				mobileUserAddressVO.setIsMain(temp.getIsMain());
				mobileUserAddressVO.setUserId(temp.getUserId());
				mobileUserAddressVO.setPhone(temp.getPhone());
				mobileUserAddressVO.setId(temp.getId());
				resutlAddressList.add(mobileUserAddressVO);
			}
		}
		return resutlAddressList;
	}
  
  
}
