package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.UserAddress;
import com.csj.gold.service.UserAddressService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/userAddress")
public class UserAddressController {
	
	private int pageSize = 10;

	@Resource
	UserAddressService userAddressService = null;

	@RequestMapping("/add")
	public String add(@Param("userAddress") UserAddress userAddress) {
		userAddressService.add(userAddress);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("userAddress") UserAddress userAddress) {
		userAddressService.update(userAddress);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("userAddress") UserAddress userAddress) {
		userAddressService.delete(userAddress);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("userAddress") UserAddress userAddress) {
		userAddressService.forbidden(userAddress);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("userAddress") UserAddress userAddress,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		userAddressService.searchByParameters(page,userAddress);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("userAddress") UserAddress userAddress) {
		userAddressService.searchByPrimaryKey(userAddress);
		return null;
	}

}
